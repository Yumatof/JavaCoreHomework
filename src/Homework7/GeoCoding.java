package Homework7;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GeoCoding {
    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper= new ObjectMapper();

    private String API_LINK;
    private String API_KEY;

    private String responseCityCoordinates;
    private String lon;
    private String lot;

    public GeoCoding(String cityName, String API_LINK, String API_KEY) throws IOException {
        this.API_LINK=API_LINK;
        this.API_KEY=API_KEY;
        getCoordinates(cityName);
    }
    private void getCoordinates(String cityName) throws IOException {
        String jsonCityCoordinates = API_LINK + "/geo/1.0/direct?q=" + cityName + "&limit=1" + API_KEY;

        Request requestCityCoordinates = new Request.Builder()
                .url(jsonCityCoordinates)
                .build();

        Response jsonResponse = client.newCall(requestCityCoordinates).execute();
        if (!jsonResponse.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + jsonResponse.code() + " тело ответа = " + jsonResponse.body().string());
        }
        responseCityCoordinates = deleteSymbol(jsonResponse.body().string());
        System.out.println("\nПроизвожу поиск города " + cityName);

        if (objectMapper.readTree(responseCityCoordinates).size() == 0) {
            throw new IOException("Server returns 0 cities");
        }

    }

    private String deleteSymbol(String tmpStr1) {
        String tmpStr2 = tmpStr1.replace("[", "");
        return tmpStr2.replace("]", "");
    }

    public String getLon() throws JsonProcessingException {
        JsonNode lon = objectMapper
                .readTree(responseCityCoordinates)
                .at("/lon");
        return lon.asText();
    }
    public String getLat() throws JsonProcessingException {
        JsonNode lat = objectMapper
                .readTree(responseCityCoordinates)
                .at("/lat");
        return lat.asText();
    }
}
