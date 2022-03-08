package Homework7;

import java.io.IOException;
import java.util.Scanner;

public class Builder {

    private final String API_LINK = "http://api.openweathermap.org";
    private final String API_KEY = "&appid=9289b9e923af5bfff57ca20ab5e6a133";
    private Scanner scanner = new Scanner(System.in);
    private String lon;
    private String lat;
    private String cityName;


    public void runApplication() throws IOException {
        while(true){
            System.out.print("Введите название города \n в котором Вам нужно узнать погоду > ");
            cityName = scanner.nextLine();
            getCoordinates(cityName);

            System.out.print("\nВыберите тип прогноза:\n " +
                    " - введите 1 если Вам нужен прогноз на сегодня;\n" +
                    " - введите 2 если Вам нужен прогноз на ближайшие 5 дней;\n" +
                    " - введите 0 для выхода из приложения\n > ");
            String result = scanner.nextLine();
            checkInputToExit(result);

            try {
                validateInputValue(result);
            }catch (IOException e){
                e.printStackTrace();
            }

            switch (result){
                case "1":
                    CurrentForecast currentForecast = new CurrentForecast(cityName, lon,lat, API_LINK, API_KEY);
                    break;
                case "2":
                    FiveDayForecast fiveDayForecast = new FiveDayForecast(cityName, lon,lat, API_LINK, API_KEY);
                    break;
            }
        }

    }
    public void getCoordinates(String CityName) throws IOException {
        GeoCoding geoCoding = new GeoCoding(CityName, API_LINK, API_KEY);
        lon = geoCoding.getLon();
        lat = geoCoding.getLat();
    }

    public void checkInputToExit(String result){
        if(result.equals("0")){
            System.out.println("Завершение работы приложения");
            System.exit(0);
        }
    }
    public void validateInputValue (String inputStr) throws IOException {
        if(inputStr.length() !=1 || inputStr == null){
            throw new IOException("The entered value does not match the conditions " +
                                    "or you entered an empty value");
        }
        try{
            int answer = Integer.parseInt(inputStr);
        } catch (NumberFormatException e){
            throw new IOException("The entered value is not a number");
        }

    }




}
