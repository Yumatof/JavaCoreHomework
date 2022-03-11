package Homework7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class OpenWeatherMapProvider {
    private final String BASE_HOST= "api.openweathermap.org";
    private final String TYPE_REQUEST_DATA = "data";
    private final String TYPE_REQUEST_GEO ="geo";
    private final String API_VERSION_DATA = "2.5";
    private final String API_VERSION_GEO = "1.0";
    private final String FORECAST_ENDPOINT = "forecasts";
    private final String WEATHER_ENDPOINT = "weather";
    private final String GEO_ENDPOINT = "direct";
    private final String API_KEY = "9289b9e923af5bfff57ca20ab5e6a133";

    private String lon;
    private String lat;

    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();

    public void currentForecast(String cityName) throws IOException {
        takeCoordinates(cityName);
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

    public void FiveDayForecast(String cityName) throws IOException{
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
        printForecastFiveDay(response);


    }

    private void takeCoordinates(String cityName) throws IOException {
        HttpUrl takeCoordinates =  new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(TYPE_REQUEST_GEO)
                .addPathSegment(API_VERSION_GEO)
                .addPathSegment(GEO_ENDPOINT)
                .addQueryParameter("q", "cityName")
                .addQueryParameter("limit", "1")
                .addQueryParameter("lang", "ru")
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
        System.out.println("Произвожу поиск города " + cityName);

        if (mapper.readTree(responseCityCoordinates).size() == 0) {
            throw new IOException("Server returns 0 cities");
        }
        lon = mapper
                .readTree(responseCityCoordinates)
                .at("/lon")
                .asText();
        lat = mapper
                .readTree(responseCityCoordinates)
                .at("/lat")
                .asText();
    }
    private String deleteSymbol(String tmpStr1) {
        String tmpStr2 = tmpStr1.replace("[", "");
        return tmpStr2.replace("]", "");
    }
    private void printCurrentForecast(String response, String cityName) throws JsonProcessingException {
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


        System.out.println("В городе " + cityName + " на данный момент времени " + description + ";\n"
                +" - ветер " +windDirection(windDirectionStr)+ ", скорость ветра: " + windSpeed +" м/с, порывы до " + windGust + " м/с\n;"
                +" - температура воздуха: " + temperature + " Cº.");
    }
    private String windDirection(String windDirectionStr) throws JsonProcessingException {
        int windDirectionInt = Integer.parseInt(windDirectionStr);
        if((windDirectionInt > -1 && windDirectionInt < 23)||(windDirectionInt > 336 && windDirectionInt < 361)){
            return "северный";
        } else if(windDirectionInt > 22 && windDirectionInt < 68){
            return "северо-восточный";
        } else if(windDirectionInt > 67 && windDirectionInt < 112){
            return "восточный";
        } else if(windDirectionInt > 111 && windDirectionInt < 158) {
            return "юго-восточный";
        }else if(windDirectionInt > 157 && windDirectionInt < 203) {
            return "южный";
        }else if(windDirectionInt > 202 && windDirectionInt < 248) {
            return "юго-западный";
        }else if(windDirectionInt > 247 && windDirectionInt < 293) {
            return "западный";
        }else if(windDirectionInt > 292 && windDirectionInt < 337) {
            return "северо-западный";}
        return null;
    }

    private void printForecastFiveDay(String response) throws JsonProcessingException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        WeatherResponse weatherResponse = mapper.readValue(response, WeatherResponse.class);

        List<WeatherResponse.Day> listForecast = WeatherResponse.getList();

        for (WeatherResponse.Day element : listForecast) {
            List<WeatherResponse.Day.Weather> weatherDiscription = element.getWeather();
                    System.out.println("Дата: " + element.getDt_txt() + "\n "
                    +"Погода: \n"
                    +" - " + weatherDiscription.get(0).getDescription() + ";\n"
                    +" - ветер " +windDirection(String.valueOf(element.getWind().getDeg()))+ ", скорость ветра: " + element.getWind().getSpeed() +" м/с, порывы до " + element.getWind().getGust() + " м/с\n;"
                    +" - температура воздуха: " + element.getMain().getTemp() + " Cº.");
        }
    }
}
