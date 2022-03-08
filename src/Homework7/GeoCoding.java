package Homework7;

import Homework7.Enums.EnumsApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class GeoCoding {
    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper= new ObjectMapper();

    private String responseCityCoordinates;
    private String lon;
    private String lot;

    public GeoCoding(String cityName) throws IOException {
        getCoordinates(cityName);
    }
    private void getCoordinates(String cityName) throws IOException {
        String jsonCityCoordinates = EnumsApi.API_LINK.getValue() + "/geo/1.0/direct?q=" + cityName + "&limit=1" + EnumsApi.API_KEY.getValue();

        Request requestCityCoordinates = new Request.Builder()
                .url(jsonCityCoordinates)
                .build();

        responseCityCoordinates = deleteSymbol
                (client.newCall(requestCityCoordinates).execute().body().string());
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
