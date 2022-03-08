package Homework7;


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

    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper= new ObjectMapper();


    public CurrentForecast(String cityName, String lon, String lat, String API_LINK, String API_KEY) {
        this.cityName=cityName;
        this.lon=lon;
        this.lat=lat;
        this.API_LINK = API_LINK;
        this.API_KEY=API_KEY;
    }
    public void getForecast() throws IOException {
        String jsonForecastCurrentWeather = API_LINK + "/data/2.5/weather?lat=" + lat + "&lon=" + lon + API_KEY;
        Request requestForecastCurrent = new Request.Builder()
                .url(jsonForecastCurrentWeather)
                .build();
        String responseForecastCurrent = client.newCall(requestForecastCurrent).execute().body().string();

    }

    public void printForecast(){
        System.out.println("В городе " + cityName + "на данный момент времени следующа погода:\n"
        + "");
    }

    public class CurrentWeather {

        private String base;
        Main MainObject;
        private float visibility;
        Wind WindObject;
        Clouds CloudsObject;
        private float dt;
        Sys SysObject;
        private float timezone;
        private float id;
        private String name;
        private float cod;


        // Getter Methods

        public Main getMain() {
            return MainObject;
        }

        public float getVisibility() {
            return visibility;
        }

        public Wind getWind() {
            return WindObject;
        }

        public Clouds getClouds() {
            return CloudsObject;
        }

        public float getDt() {
            return dt;
        }

        public Sys getSys() {
            return SysObject;
        }

        public float getTimezone() {
            return timezone;
        }

        public float getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public float getCod() {
            return cod;
        }

        // Setter Methods

        public void setMain(Main mainObject) {
            this.MainObject = mainObject;
        }

        public void setVisibility(float visibility) {
            this.visibility = visibility;
        }

        public void setWind(Wind windObject) {
            this.WindObject = windObject;
        }

        public void setClouds(Clouds cloudsObject) {
            this.CloudsObject = cloudsObject;
        }

        public void setDt(float dt) {
            this.dt = dt;
        }

        public void setSys(Sys sysObject) {
            this.SysObject = sysObject;
        }

        public void setTimezone(float timezone) {
            this.timezone = timezone;
        }

        public void setId(float id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCod(float cod) {
            this.cod = cod;
        }
    }
    public class Sys {
        private float type;
        private float id;
        private String country;
        private float sunrise;
        private float sunset;


        // Getter Methods

        public float getType() {
            return type;
        }

        public float getId() {
            return id;
        }

        public String getCountry() {
            return country;
        }

        public float getSunrise() {
            return sunrise;
        }

        public float getSunset() {
            return sunset;
        }

        // Setter Methods

        public void setType(float type) {
            this.type = type;
        }

        public void setId(float id) {
            this.id = id;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setSunrise(float sunrise) {
            this.sunrise = sunrise;
        }

        public void setSunset(float sunset) {
            this.sunset = sunset;
        }
    }
    public class Clouds {
        private float all;


        // Getter Methods

        public float getAll() {
            return all;
        }

        // Setter Methods

        public void setAll(float all) {
            this.all = all;
        }
    }
    public class Wind {
        private float speed;
        private float deg;


        // Getter Methods

        public float getSpeed() {
            return speed;
        }

        public float getDeg() {
            return deg;
        }

        // Setter Methods

        public void setSpeed(float speed) {
            this.speed = speed;
        }

        public void setDeg(float deg) {
            this.deg = deg;
        }
    }
    public class Main {
        private float temp;
        private float feels_like;
        private float temp_min;
        private float temp_max;
        private float pressure;
        private float humidity;


        // Getter Methods

        public float getTemp() {
            return temp;
        }

        public float getFeels_like() {
            return feels_like;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public float getTemp_max() {
            return temp_max;
        }

        public float getPressure() {
            return pressure;
        }

        public float getHumidity() {
            return humidity;
        }

        // Setter Methods

        public void setTemp(float temp) {
            this.temp = temp;
        }

        public void setFeels_like(float feels_like) {
            this.feels_like = feels_like;
        }

        public void setTemp_min(float temp_min) {
            this.temp_min = temp_min;
        }

        public void setTemp_max(float temp_max) {
            this.temp_max = temp_max;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }
    }




}
