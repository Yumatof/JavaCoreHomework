package Homework7;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

        ArrayList <Day> list = new ArrayList <> ();

        public ArrayList<Day> getList() {
            return list;
        }
        public void setList(ArrayList<Day> list) {
            this.list = list;
        }

         class Day {
            private Main MainObject;
            private ArrayList< Weather > weather = new ArrayList < Weather > ();
            private Wind WindObject;
            private String dt_txt;

            // Getter Methods
            public Main getMain() {
                return MainObject;
            }
            public Wind getWind() {
                return WindObject;
            }
            public String getDt_txt() {
                return dt_txt;
            }
             public ArrayList<Weather> getWeather() {
                 return weather;
             }

             // Setter Methods
            public void setMain(Main mainObject) {
                this.MainObject = mainObject;
            }
            public void setWind(Wind windObject) {
                this.WindObject = windObject;
            }
            public void setDt_txt(String dt_txt) {
                this.dt_txt = dt_txt;
            }
             public void setWeather(ArrayList<Weather> weather) {
                 this.weather = weather;
             }

             class Wind {
                private float speed;
                private float deg;
                private float gust;

                // Getter Methods
                public float getSpeed() {
                    return speed;
                }
                public float getDeg() {
                    return deg;
                }
                public float getGust() {
                    return gust;
                }
                // Setter Methods
                public void setSpeed(float speed) {
                    this.speed = speed;
                }
                public void setDeg(float deg) {
                    this.deg = deg;
                }
                public void setGust(float gust) {
                    this.gust = gust;
                }
            }
             class Main {
                private float temp;

                // Getter Methods
                public float getTemp() {
                    return temp;
                }
                // Setter Methods
                public void setTemp(float temp) {
                    this.temp = temp;
                }
             }
             class Weather{
                 private String description;

                 // Getter Methods
                 public String getDescription() {
                     return description;
                 }
                 // Setter Methods
                 public void setDescription(String description) {
                     this.description = description;
                 }
             }
        }
}
