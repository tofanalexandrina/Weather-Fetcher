package com.weatherfetcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherfetcher.model.WeatherResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class WeatherFetcher {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("City ('exit' to quit): ");
            String city=scanner.nextLine();

            if(city.equalsIgnoreCase("exit")){
                break;
            }
            HttpClient client= HttpClient.newHttpClient();
            String apiKey=System.getenv("WEATHER_API_KEY");
            // /current.json - endpoint for current weather in JSON format(from documentation)
            String url="https://api.weatherapi.com/v1/current.json?key="+apiKey+"&q="+city;

            //syntax breakdown:
            // newBuilder - starts creating a new request
            // .uri(URI.create(url)) - converts the URL string into a URI object
            // ! Java's HTTP client works with URI(Uniform Resource Identifier), not raw strings
            // .build() returns an HttpRequest usable object
            HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).build();
            //the body of the response is read as text(String)
            HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());

            //using Jackson to convert JSON response into Java obj
            ObjectMapper mapper=new ObjectMapper();
            WeatherResponse weatherResponse=mapper.readValue(response.body(), WeatherResponse.class);

            //access the data
            System.out.println("City: "+weatherResponse.location.name);
            System.out.println("Country: "+weatherResponse.location.country);
            System.out.println("Temperature: "+weatherResponse.current.temp_c+" °C");
            System.out.println("Condition: "+weatherResponse.current.condition.text);
        }


    }
}
