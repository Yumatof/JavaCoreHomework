package Homework7;

import Homework7.MyException.InvalidDateException;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private OpenWeatherMapProvider openWeatherMapProvider = new OpenWeatherMapProvider();
    public Scanner scan = new Scanner(System.in);

    void UserInput(String cityName, String result) throws IOException, InvalidDateException {
        switch (result){
            case "1":
                OpenWeatherMapProvider.currentForecast(cityName);
                break;
            case "2":
                OpenWeatherMapProvider.FiveDayForecast(cityName);
                break;
            case "3":
                System.out.print("Введите дату в формате - \"YYYY-MM-DD HH-00-00\"  >");
                String inputDate = scan.nextLine();
                validateInputDate(inputDate);
                OpenWeatherMapProvider.getForecastFromDB(inputDate);
                break;
            case "0":
                System.out.println("Завершение работы приложения");
                System.exit(0);
                break;
            default:
                throw new IOException("There is no command for command-key " + result);
        }
    }

    public void validateInputDate (String inputStr) throws IOException {
        if(inputStr.length() !=19 || inputStr == null){
            throw new IOException("The entered date does not match the conditions " +
                    "or you entered an empty value");
        }
    }

}
