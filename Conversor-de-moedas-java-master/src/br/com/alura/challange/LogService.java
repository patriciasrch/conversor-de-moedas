package br.com.alura.challange;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogService {
    private static final String LOG_FILE = "conversions.json";
    private Gson gson;

    public LogService() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void log(ConversionRecord record) {
        try {
            JsonArray jsonArray;
            try (FileReader reader = new FileReader(LOG_FILE)) {
                JsonElement jsonElement = JsonParser.parseReader(reader);
                if (jsonElement.isJsonArray()) {
                    jsonArray = jsonElement.getAsJsonArray();
                } else {
                    jsonArray = new JsonArray();
                }
            } catch (IOException e) {
                jsonArray = new JsonArray();
            }

            JsonElement recordJson = gson.toJsonTree(record);
            jsonArray.add(recordJson);

            try (FileWriter writer = new FileWriter(LOG_FILE)) {
                gson.toJson(jsonArray, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

