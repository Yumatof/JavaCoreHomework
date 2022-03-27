package Homework7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class OpenWeatherMapProvider {
    private final static String BASE_HOST= "api.openweathermap.org";
    private final static String TYPE_REQUEST_DATA = "data";
    private final static String TYPE_REQUEST_GEO ="geo";
    private final static String API_VERSION_DATA = "2.5";
    private final static String API_VERSION_GEO = "1.0";
    private final static String FORECAST_ENDPOINT = "forecast";
    private final static String WEATHER_ENDPOINT = "weather";
    private final static String GEO_ENDPOINT = "direct";
    private final static String API_KEY = "9289b9e923af5bfff57ca20ab5e6a133";

    private static OkHttpClient client = new OkHttpClient();
    private static ObjectMapper mapper = new ObjectMapper();
    private static StringBuilder stringBuilder = new StringBuilder();
    private static ForecastFiveDayDatabaseSQLite DB = new ForecastFiveDayDatabaseSQLite();

    private final static String IN_CITY = "В городе ";
    private final static String DATA_LINE_BEGIN = "Дата: ";
    private final static String IN_NOW_TIME = " на данный момент времени ";
    private final static String LINE_BEGIN = " - ";
    private final static String LINE_END_AND_BREAK = ";\n";
    private final static String WIND_LINE_BEGIN = " - ветер ";
    private final static String WIND_SPEED = ", скорость ветра: ";
    private final static String UNIT_METR_PER_SECOND = " м/с";
    private final static String GUST = ", порывы до ";
    private final static String TEMPERATURE_LINE_BEGIN =" - температура воздуха: ";
    private final static String UNIT_CELSIUS = " Cº";
    private final static String END_POINT_AND_BREAK = ".\n";
    private final static String  LINE_SEPARATOR = "****************\n";

    public static void currentForecast(String cityName) throws IOException {
        HashMap hm = takeCoordinates(cityName);
        String lon = (String) hm.get("lon");
        String lat = (String) hm.get("lat");

        HttpUrl takeCurrentForecast =  new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(TYPE_REQUEST_DATA)
                .addPathSegment(API_VERSION_DATA)
                .addPathSegment(WEATHER_ENDPOINT)
                .addQueryParameter("lat", lat)
                .addQueryParameter("lon", lon)
                .addQueryParameter("units", "metric")
                .addQueryParameter("lang", "ru")
                .addQueryParameter("appid", API_KEY)
                .build();

        Request requestCurrentForecastCurrent = new Request.Builder()
                .url(takeCurrentForecast)
                .build();
        String responseCurrentForecast = client.newCall(requestCurrentForecastCurrent).execute().body().string();
        printCurrentForecast(responseCurrentForecast, cityName);
    }
    public static void FiveDayForecast(String cityName) throws IOException{
        HashMap hm = takeCoordinates(cityName);
        String lon = (String) hm.get("lon");
        String lat = (String) hm.get("lat");


        HttpUrl takeFiveDayForecast =  new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(TYPE_REQUEST_DATA)
                .addPathSegment(API_VERSION_DATA)
                .addPathSegment(FORECAST_ENDPOINT)
                .addQueryParameter("units", "metric")
                .addQueryParameter("lang", "ru")
                .addQueryParameter("appid", API_KEY)
                .addQueryParameter("lat", lat)
                .addQueryParameter("lon", lon)
                .build();

        Request request = new Request.Builder()
                .url(takeFiveDayForecast)
                .build();
        String response = client.newCall(request).execute().body().string();
        printForecastFiveDay(response, cityName);
    }
    public static void getForecastFromDB(String date){
        DB.selectForecast(date);
    }

    private static HashMap takeCoordinates(String cityName) throws IOException {
        HashMap<String, String> hm = new HashMap<>();

        HttpUrl takeCoordinates =  new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(TYPE_REQUEST_GEO)
                .addPathSegment(API_VERSION_GEO)
                .addPathSegment(GEO_ENDPOINT)
                .addQueryParameter("q", cityName)
                .addQueryParameter("limit", "1")
                .addQueryParameter("appid", API_KEY)
                .build();

        Request requestCityCoordinates = new Request.Builder()
                .url(takeCoordinates)
                .build();

        Response jsonResponse = client.newCall(requestCityCoordinates).execute();
        if (!jsonResponse.isSuccessful()) {
            throw new IOException("Невозможно прочесть информацию о городе. " +
                    "Код ответа сервера = " + jsonResponse.code() + " тело ответа = " + jsonResponse.body().string());
        }
        String responseCityCoordinates = deleteSymbol(jsonResponse.body().string());
        System.out.println("Производится поиск города " + cityName);

        if (mapper.readTree(responseCityCoordinates).size() == 0) {
            throw new IOException("Server returns 0 cities");
        }

        hm.put("lon", mapper
                .readTree(responseCityCoordinates)
                .at("/lon")
                .asText());
        hm.put("lat", mapper
                .readTree(responseCityCoordinates)
                .at("/lat")
                .asText());
        return hm;
    }
    private static String deleteSymbol(String tmpStr1) {
        String tmpStr2 = tmpStr1.replace("[", "");
        return tmpStr2.replace("]", "");
    }
    private static void printCurrentForecast(String response, String cityName) throws JsonProcessingException {
        System.out.println("Производится поиск погоды в городе " + cityName);
        String description = mapper
                .readTree(response)
                .at("/weather/description")
                .asText();

        String windSpeed = mapper
                .readTree(response)
                .at("/wind/speed")
                .asText();

        String windGust = mapper
                .readTree(response)
                .at("/wind/gust")
                .asText();

        String temperature =mapper
                .readTree(response)
                .at("/main/temp")
                .asText();

        String windDirectionStr= mapper
                .readTree(response)
                .at("/wind/deg")
                .asText();
        Float windDirectionFloat = Float.valueOf(windDirectionStr);
        stringBuilder.append(IN_CITY)
                .append(cityName)
                .append(IN_NOW_TIME)
                .append(description)
                .append(LINE_END_AND_BREAK)
                .append(WIND_LINE_BEGIN)
                .append(windDirection(windDirectionFloat))
                .append(WIND_SPEED)
                .append(windSpeed)
                .append(UNIT_METR_PER_SECOND)
                .append(GUST)
                .append(windGust)
                .append(UNIT_METR_PER_SECOND)
                .append(LINE_END_AND_BREAK)
                .append(TEMPERATURE_LINE_BEGIN)
                .append(temperature)
                .append(UNIT_CELSIUS)
                .append(END_POINT_AND_BREAK);

        System.out.println(stringBuilder);
    }
    private static void printForecastFiveDay(String response, String cityName) throws JsonProcessingException {
        System.out.println("Производится поиск погоды в городе " + cityName);
        WeatherResponse weatherResponse = mapper.readValue(response, WeatherResponse.class);

        ArrayList<WeatherResponse.Day> listForecast = weatherResponse.getList();
        for (WeatherResponse.Day element : listForecast) {
            ArrayList<WeatherResponse.Day.Weather> weatherDiscription = element.getWeather();
            System.out.println(LINE_SEPARATOR);
            stringBuilder.append(LINE_BEGIN)
                    .append(weatherDiscription.get(0).getDescription())
                    .append(LINE_END_AND_BREAK)
                    .append(WIND_LINE_BEGIN)
                    .append(windDirection(element.getWind().getDeg()))
                    .append(WIND_SPEED)
                    .append(element.getWind().getSpeed())
                    .append(UNIT_METR_PER_SECOND)
                    .append(GUST)
                    .append(element.getWind().getGust())
                    .append(UNIT_METR_PER_SECOND)
                    .append(LINE_END_AND_BREAK)
                    .append(TEMPERATURE_LINE_BEGIN)
                    .append(element.getMain().getTemp())
                    .append(UNIT_CELSIUS)
                    .append(END_POINT_AND_BREAK);

            //DB.insertForecast(cityName,element.getDt_txt(), String.valueOf(stringBuilder));

            stringBuilder.insert(0, DATA_LINE_BEGIN + element.getDt_txt() + LINE_END_AND_BREAK)
                         .append(LINE_SEPARATOR);

            System.out.println(stringBuilder);
        }
    }

    private static String windDirection(Float windDirectionFloat) {
        if((windDirectionFloat > -1 && windDirectionFloat < 23)||(windDirectionFloat > 336 && windDirectionFloat < 361)){
            return "северный";
        } else if(windDirectionFloat > 22 && windDirectionFloat < 68){
            return "северо-восточный";
        } else if(windDirectionFloat > 67 && windDirectionFloat < 112){
            return "восточный";
        } else if(windDirectionFloat > 111 && windDirectionFloat < 158) {
            return "юго-восточный";
        }else if(windDirectionFloat > 157 && windDirectionFloat < 203) {
            return "южный";
        }else if(windDirectionFloat > 202 && windDirectionFloat < 248) {
            return "юго-западный";
        }else if(windDirectionFloat > 247 && windDirectionFloat < 293) {
            return "западный";
        }else if(windDirectionFloat > 292 && windDirectionFloat < 337) {
            return "северо-западный";}
        return null;
    }

}
