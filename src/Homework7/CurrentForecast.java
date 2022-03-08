package Homework7;


import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class CurrentForecast {

    private String lon;
    private String lat;
    private String API_LINK;
    private String API_KEY;
    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper= new ObjectMapper();


    public CurrentForecast(String lon, String lat, String API_LINK, String API_KEY) {
        this.lon=lon;
        this.lat=lat;
        this.API_LINK = API_LINK;
        this.API_KEY=API_KEY;
    }
    public void getforecast() throws IOException {
        String jsonForecastCurrentWeather = API_LINK + "/data/2.5/weather?lat=" + lat + "&lon=" + lon + API_KEY;
        Request requestForecastCurrent = new Request.Builder()
                .url(jsonForecastCurrentWeather)
                .build();
        String responseForecastCurrent = client.newCall(requestForecastCurrent).execute().body().string();
    }









}
