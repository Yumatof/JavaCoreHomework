package Homework7;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class CurrentForecast {

    private String lon;
    private String lat;
    private String API_LINK;
    private String API_KEY;
    private String cityName;
    private String responseForecastCurrent;

    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper= new ObjectMapper();


    public CurrentForecast(String cityName, String lon, String lat, String API_LINK, String API_KEY) {
        this.cityName=cityName;
        this.lon=lon;
        this.lat=lat;
        this.API_LINK = API_LINK;
        this.API_KEY=API_KEY;
        System.out.println("Произвожу поиск сведений о погоде в городе " + cityName);
    }
    public void getForecast() throws IOException {
        String jsonForecastCurrentWeather = API_LINK + "/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&units=metric&lang=ru" + API_KEY;
        Request requestForecastCurrent = new Request.Builder()
                .url(jsonForecastCurrentWeather)
                .build();
        responseForecastCurrent = deleteSymbol
                (client.newCall(requestForecastCurrent).execute().body().string());
        printForecast();
    }

    private void printForecast() throws JsonProcessingException {
        System.out.println("В городе " + cityName + " на данный момент времени " + getDescription() + "\n"
                +" - ветер " +getWindDirection()+ ", скорость ветра: " + getWindSpeed() +" м/с, порывы до " + getGust() + " м/с\n"
                +" - температура воздуха: " + getTemperature() + " Cº");
    }

    private String deleteSymbol(String tmpStr1) {
        String tmpStr2 = tmpStr1.replace("[", "");
        return tmpStr2.replace("]", "");
    }

    private String getDescription() throws JsonProcessingException {
        JsonNode description = objectMapper
                .readTree(responseForecastCurrent)
                .at("/weather/description");
        return description.asText();
    }

    private String getWindSpeed() throws JsonProcessingException {
        JsonNode windSpeed = objectMapper
                .readTree(responseForecastCurrent)
                .at("/wind/speed");
        return windSpeed.asText();
    }
    private String getTemperature () throws JsonProcessingException {
        JsonNode temperature = objectMapper
                .readTree(responseForecastCurrent)
                .at("/main/temp");
        return temperature.asText();
    }
    private String getGust() throws JsonProcessingException{
        JsonNode gust = objectMapper
                .readTree(responseForecastCurrent)
                .at("/wind/gust");
        return gust.asText();
    }
    private String getWindDirection() throws JsonProcessingException{
        JsonNode windDirectionStr = objectMapper
                .readTree(responseForecastCurrent)
                .at("/wind/deg");
        int windDirectionInt = Integer.parseInt(windDirectionStr.asText());

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


}
