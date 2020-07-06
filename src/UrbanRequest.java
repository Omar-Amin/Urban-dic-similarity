import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class UrbanRequest {

    private final String API_KEY = "API_KEY";

    UrbanRequest(){
    }

    JsonNode requestWord(String word){
        HttpResponse<JsonNode> response = Unirest.get("https://mashape-community-urban-dictionary.p.rapidapi.com/define?term=" + word)
                .header("x-rapidapi-host", "mashape-community-urban-dictionary.p.rapidapi.com")
                .header("x-rapidapi-key", API_KEY)
                .asJson();

        return response.getBody();
    }

}
