import javafx.util.Pair;
import kong.unirest.JsonNode;

public class CompareDictionaries {

    /**
     * Retrieves description for a work from urban dictionary and wiktionary.
     * */
    static Pair<String,String> getDescriptions(String word){
        // requests the word with an API from urban dictionary and retrieves the first definition
        UrbanRequest urbanRequest = new UrbanRequest();
        JsonNode node = urbanRequest.requestWord(word);
        String urbanDescription = node.getObject().getJSONArray("list").getJSONObject(0).get("definition").toString();

        return new Pair<>(urbanDescription,"");
    }

    static float getSimilarity(String s1, String s2){
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        return cosineSimilarity.findSimilarity(s1,s2);
    }

}
