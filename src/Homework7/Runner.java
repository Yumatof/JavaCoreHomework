package Homework7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.*;


public class Runner {



    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        //API_LINK + "/data/2.5/weather?lat={lat}&lon={lon}&appid=" + API_KEY

        /*
        String jsonForecastWeather5d = API_LINK + "/data/2.5/forecast?lat=59.938732&lon=30.316229&units=metric&appid="+API_KEY;;

        Request requestForecast5d = new Request.Builder()
                .url(API_LINK)
                .build();

        Response responseForecast5d = client.newCall(requestForecast5d).execute();
        responseForecast5d.body().string();
         */






        //StringReader readerCityCoordinates = new StringReader(responseCityCoordinates);



        GeoCoding geoCoding = new GeoCoding("петербург");
        System.out.println(GeoCoding.getLon());
    }



    public static class GeoCoding{
        OkHttpClient client = new OkHttpClient();
        private static ObjectMapper objectMapper= new ObjectMapper();

        private static final String API_KEY = "9289b9e923af5bfff57ca20ab5e6a133";
        private static final String API_LINK = "http://api.openweathermap.org";

        private static String cityName;
        private static String responseCityCoordinates;
        private static String lon;
        private static String lot;

        public GeoCoding(String cityName) throws IOException {
            this.cityName = cityName;

            getCoordinates(cityName);
        }
        private void getCoordinates(String cityName) throws IOException {
            String jsonCityCoordinates = API_LINK + "/geo/1.0/direct?q=" + cityName + "&limit=1&appid=" + API_KEY;

            Request requestCityCoordinates = new Request.Builder()
                    .url(jsonCityCoordinates)
                    .build();

           responseCityCoordinates = deleteSymbol
                    (client.newCall(requestCityCoordinates).execute().body().string());

        }

        private static String deleteSymbol(String tmpStr1) {
            String tmpStr2 = tmpStr1.replace("[", "");
            return tmpStr2.replace("]", "");
        }

        public static String getLon() throws JsonProcessingException {
            JsonNode lon = objectMapper
                    .readTree(responseCityCoordinates)
                    .at("/lon");

            return lon.asText();
        }
    }

}

