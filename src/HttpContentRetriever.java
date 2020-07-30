import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpContentRetriever {
    public HttpContentRetriever() {

    }

    public String retrieveContentAsStringFromUri(String uri) {
        String responseString = null;

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            responseString = httpResponse.body();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseString;
    }
}
