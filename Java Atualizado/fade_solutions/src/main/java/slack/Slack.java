package slack;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

/**
 *
 * @author Sergio Trindade
 */
public class Slack {

    private static HttpClient client  = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";

    public static void EnviarMensagem(String teste)  {
        JSONObject json = new JSONObject();
        json.put("text",teste);

        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        try {
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (Exception e){
            e.printStackTrace();
        }




    }

}
