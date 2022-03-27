package Homework7;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private OpenWeatherMapProvider openWeatherMapProvider = new OpenWeatherMapProvider();
    public Scanner scan = new Scanner(System.in);

    void UserInput(String cityName, String result) throws IOException {
        switch (result){
            case "1":
                OpenWeatherMapProvider.currentForecast(cityName);
                break;
            case "2":
                OpenWeatherMapProvider.FiveDayForecast(cityName);
                break;
            case "3":
                System.out.print("Введите дату в формате - \"YYYY-MM-DD HH-00-00\"  >");
                //getForecast(scan.nextLine());
                break;
            case "0":
                System.out.println("Завершение работы приложения");
                System.exit(0);
                break;
            default:
                throw new IOException("There is no command for command-key " + result);
        }
    }
}
