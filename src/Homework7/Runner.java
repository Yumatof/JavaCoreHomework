package Homework7;

import okhttp3.*;

import java.io.IOException;


public class Runner {
    private static final String API_KEY = "9289b9e923af5bfff57ca20ab5e6a133";
    private static final String API_LINK = "http://api.openweathermap.org";

    public static void main (String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        //API_LINK + "/data/2.5/weather?lat={lat}&lon={lon}&appid=" + API_KEY

        String jsonForecastWeather5d = API_LINK + "/data/2.5/forecast?lat=59.938732&lon=30.316229&units=metric&appid="+API_KEY;;
        RequestBody requestBodyForecastWeather5d = RequestBody.create(jsonForecastWeather5d, MediaType.parse("application/json"));

        Request requestForecast5d = new Request.Builder()
                .url(API_LINK)
                .post(requestBodyForecastWeather5d)
                .build();

        Response responseForecast5d = client.newCall(requestForecast5d).execute();
        responseForecast5d.body().string();



        String jsonCityCoordinates  = API_LINK + "/geo/1.0/direct?q=петербург&appid=" + API_KEY;
        RequestBody requestBodyCityCoordinates = RequestBody.create(jsonCityCoordinates, MediaType.parse("application/json"));

        Request requestCityCoordinates  = new Request.Builder()
                .url(API_LINK)
                .post(requestBodyCityCoordinates)
                .build();

        Response responseCityCoordinates = client.newCall(requestCityCoordinates).execute();
        responseCityCoordinates.body().string();

    }
}