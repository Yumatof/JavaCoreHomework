package Homework7;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
    private static final String API_LINK = "http://api.openweathermap.org";
    private static final String API_KEY = "&appid=9289b9e923af5bfff57ca20ab5e6a133";

    private static String cityName = "moscow";
    private static String lon = "30.316229";
    private static String lat = "59.938732";

    public static void main(String[] args) throws IOException {
/*
        Builder builder = new Builder();
        builder.runApplication();
 */

        GeoCoding geoCoding = new GeoCoding(cityName, API_LINK, API_KEY);
        System.out.println(geoCoding.getLat());

        /*
        CurrentForecast currentForecast = new CurrentForecast(cityName,lon,lat, API_LINK, API_KEY);
        currentForecast.getForecast();
         */


    }
}

