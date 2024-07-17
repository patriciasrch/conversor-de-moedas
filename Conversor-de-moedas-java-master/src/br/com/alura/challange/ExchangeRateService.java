package br.com.alura.challange;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {
    private static final String API_KEY = "e993bffa852b59f07f5d576b";
    private HttpClient client;

    public ExchangeRateService() {
        this.client = HttpClient.newHttpClient();
    }

    public double getExchangeRate(String baseCurrency, String toCurrency) {
        try {
            String urlString = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + baseCurrency;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            return conversionRates.get(toCurrency).getAsDouble();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 1.0;
        }
    }
}
