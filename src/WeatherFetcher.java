import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherFetcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client= HttpClient.newHttpClient();
        String city="Bucharest";
        String apiKey=System.getenv("WEATHER_API_KEY");
        String url="https://api.weatherapi.com/v1/current.json?key="+apiKey+"&q="+city;

        HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
