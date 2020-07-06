import javafx.util.Pair;
import kong.unirest.JsonNode;

import java.util.Arrays;

public class CompareDictionaries {

    /**
     * Retrieves definitions from UrbanDictionary.
     * */
    private static Pair<String,String[]> getDescriptions(String word, int posts){
        // requests the word with an API from urban dictionary and retrieves the first definition
        UrbanRequest urbanRequest = new UrbanRequest();
        JsonNode node = urbanRequest.requestWord(word);
        String urbanDescription = node.getObject().getJSONArray("list").getJSONObject(0).get("definition").toString();
        // finding the definitions of x posts
        int size = Math.min(node.getObject().getJSONArray("list").length(),posts);
        String[] definitions = new String[size];
        for (int i = 1; i <= size; i++) {
            definitions[i-1] = node.getObject().getJSONArray("list").getJSONObject(i).get("definition").toString();
        }

        return new Pair<>(urbanDescription,definitions);
    }

    /**
     * Finds the similarity between definitions posted in UrbanDictionary.
     * */
    static float[] getSimilarityOfDictionaries(String word,int posts){
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        Pair<String,String[]> pair = getDescriptions(word,posts);
        String urb = pair.getKey();
        String[] dic = pair.getValue();
        // finding similarity between the first and the rest of the posts
        float[] similarities = new float[dic.length];
        int i = 0;
        for (String s: dic) {
            similarities[i++] = cosineSimilarity.findSimilarity(urb,s);
        }

        return similarities;
    }

    /**
     * Method for the user to choose two sentences and find similarity
     * between them.
    */
    static float getSimilarityOfStrings(String s1, String s2){
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        return cosineSimilarity.findSimilarity(s1,s2);
    }

}
