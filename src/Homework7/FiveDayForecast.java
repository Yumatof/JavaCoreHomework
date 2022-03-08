package Homework7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class FiveDayForecast {
    private String lon;
    private String lat;
    private String API_LINK;
    private String API_KEY;
    private String cityName;

    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper= new ObjectMapper();

    public FiveDayForecast(String cityName, String lon, String lat, String API_LINK, String API_KEY) {
        this.cityName=cityName;
        this.lon=lon;
        this.lat=lat;
        this.API_LINK = API_LINK;
        this.API_KEY=API_KEY;
    }








    /*
        //запрос прогноза на 5 дней
        String jsonForecastWeather5d = EnumsApi.API_LINK.getValue()
        + "/data/2.5/forecast?lat=" + geoCoding.getLat
        + "&lon=" + geoCoding.getLon()
        + EnumsApi.API_KEY.getValue();

        Request requestForecast5d = new Request.Builder()
                .url(jsonForecastWeather5d)
                .build();

        String responseForecast5d = client.newCall(requestForecast5d).execute().body().string();
        */


}
