package Homework7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.*;


public class Runner {
    private static final String API_KEY = "9289b9e923af5bfff57ca20ab5e6a133";
    private static final String API_LINK = "http://api.openweathermap.org";
    private static final String FILE_PATH = "src/Homework7/tmp.txt";

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


        String jsonCityCoordinates = API_LINK + "/geo/1.0/direct?q=петербург&limit=5&appid=" + API_KEY;

        Request requestCityCoordinates = new Request.Builder()
                .url(jsonCityCoordinates)
                .build();

        String responseCityCoordinates = deleteSymbol(client.newCall(requestCityCoordinates).execute().body().string());



        StringReader readerCityCoordinates = new StringReader(responseCityCoordinates);
        CityCoordinates cityCoordinates = objectMapper.readValue(readerCityCoordinates, CityCoordinates.class);
        System.out.println(cityCoordinates.getLon());


    }
    private static String deleteSymbol(String tmpStr1){

        String tmpStr2 =  tmpStr1.replace("[","");
        return  tmpStr2.replace("]","");
    }



    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CityCoordinates {
        private String lat;
        private String lon;
        private String name;

        public String getName() {
            return name;
        }
        public String getLat() {
            return lat;
        }
        public String getLon() {
            return lon;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }
    }

    }

