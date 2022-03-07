package Homework6;

import okhttp3.*;
import java.io.IOException;

public class Main {

    private static final String API_KEY = "9289b9e923af5bfff57ca20ab5e6a133";
    private static final String API_LINK = "http://api.openweathermap.org";

    public static void main (String [] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String jsonForecastWeather = API_LINK + "/data/2.5/forecast?lat=59.938732&lon=30.316229&units=metric&appid="+API_KEY;;

        RequestBody requstTown = RequestBody.create(jsonForecastWeather, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(API_LINK)
                .post(requstTown)
                .build();

        Response response = client.newCall(request).execute();
        response.body().string();

        System.out.println(response.code());

    }

}
