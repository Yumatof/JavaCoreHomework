package Homework7;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    private String response5dayCurrent;

    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper= new ObjectMapper();

    public FiveDayForecast(String cityName, String lon, String lat, String API_LINK, String API_KEY) {
        this.cityName=cityName;
        this.lon=lon;
        this.lat=lat;
        this.API_LINK = API_LINK;
        this.API_KEY=API_KEY;
    }
    public void getForecast() throws IOException {
        String jsonForecast5dayWeather = API_LINK + "/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&units=metric&lang=ru" + API_KEY;
        Request requestForecastCurrent = new Request.Builder()
                .url(jsonForecast5dayWeather)
                .build();
        response5dayCurrent = deleteSymbol
                (client.newCall(requestForecastCurrent).execute().body().string());
        printForecast();
    }
    private String deleteSymbol(String tmpStr1) {
        String tmpStr2 = tmpStr1.replace("[", "");
        return tmpStr2.replace("]", "");
    }
    private void printForecast() throws JsonProcessingException {
        System.out.println("В городе " + cityName + " на данный момент времени " + getDescription() + "\n"
                +" - ветер " +getWindDirection()+ ", скорость ветра: " + getWindSpeed() +" м/с, порывы до " + getGust() + " м/с\n"
                +" - температура воздуха: " + getTemperature() + " Cº");
    }



}
