package Homework7;

import Homework7.Enums.EnumsApi;

import java.io.IOException;

public class Forecast {

    public Forecast() throws IOException {

        GeoCoding geoCoding = new GeoCoding("самара");

    }

    /*
    //запрос текущей погоды
    String jsonForecastCurrentWeather = EnumsApi.API_LINK.getValue()
        + "/data/2.5/weather?lat=" + geoCoding.getLat
        + "&lon=" + geoCoding.getLon()
        + EnumsApi.API_KEY.getValue();

        Request requestForecastCurrent = new Request.Builder()
                .url(jsonForecastCurrentWeather)
                .build();

        String responseForecastCurrent = client.newCall(requestForecastCurrent).execute().body().string();

     */


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
