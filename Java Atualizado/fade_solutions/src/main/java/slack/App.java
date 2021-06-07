package slack;

import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author Sergio Trindade
 */
public class App {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        JSONObject json = new JSONObject();
        
        json.put("text", "Slack online!! :shrug:");
        
        Slack.sendMessage(json);
    }
}
