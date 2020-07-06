import javafx.util.Pair;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class CompareDictionaries {

    // TODO: Make request for both wiki and urban
    static Pair<String,String> getDescriptions(String word){
        UrbanRequest urbanRequest = new UrbanRequest();
        JsonNode node = urbanRequest.requestWord(word);

        System.out.println(node);
        return new Pair<>("","");
    }

    static float getSimilarity(String s1, String s2){
        CosineSimilarity cosineSimilarity = new CosineSimilarity();
        return cosineSimilarity.findSimilarity(s1,s2);
    }

}
