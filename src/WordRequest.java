import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class WordRequest {

    private final String API_KEY = "API_KEY";

    WordRequest(){}

    // problems with the api, doesn't work
    JsonNode requestWord(String word){
        HttpResponse<JsonNode> response = Unirest.get("https://systran-systran-platform-for-language-processing-v1.p.rapidapi.com/translation/text/translate?source=%7Ben%7D&target=%7Bdk%7D&input=%7Binput%7D")
                .header("x-rapidapi-host", "systran-systran-platform-for-language-processing-v1.p.rapidapi.com")
                .header("x-rapidapi-key", API_KEY)
                .asJson();
        return response.getBody();
    }

}
