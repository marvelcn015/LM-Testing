package final4j.lmtesting.LM;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.json.JSONObject;

import static final4j.lmtesting.Component.ApiKeySet.COHERE_API_KEY;

public class Cohere {
    private static final String API_URL = "https://api.cohere.ai/v1/generate";

    public String sendMessage(String prompt) {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(60))
                    .build();

            JSONObject requestBody = new JSONObject()
                    .put("prompt", prompt)
                    .put("max_tokens", 300)
                    .put("temperature", 0.7)
                    .put("k", 0)
                    .put("model", "command");  // or "command-light" for faster responses

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Authorization", "Bearer " + COHERE_API_KEY)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonResponse = new JSONObject(response.body());
                String generatedText = jsonResponse.getJSONArray("generations")
                        .getJSONObject(0)
                        .getString("text");

                return generatedText.trim();
            } else {
                throw new RuntimeException("API request failed with status code: "
                        + response.statusCode() + ", body: " + response.body());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error generating text: " + e.getMessage(), e);
        }
    }
}