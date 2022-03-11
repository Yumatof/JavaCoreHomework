package Homework7;

import java.io.IOException;
import java.util.Scanner;

public class Builder {

    private Scanner scanner = new Scanner(System.in);
    private OpenWeatherMapProvider openWeatherMapProvider = new OpenWeatherMapProvider();
    private String cityName;

    public void runApplication() throws IOException {
        while(true){
            System.out.print("Введите название города в котором Вам нужно узнать погоду > ");
            cityName = scanner.nextLine();

            System.out.print("\nВыберите тип прогноза:\n " +
                    " - введите 1 если Вам нужен прогноз на сегодня;\n" +
                    " - введите 2 если Вам нужен прогноз на ближайшие 5 дней;\n" +
                    " - введите 0 для выхода из приложения\n > ");
            String result = scanner.nextLine();

            try {
                validateInputValue(result);
            }catch (IOException e){
                e.printStackTrace();
            }
            initiator(result);
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
    private void initiator(String result) throws IOException {
        switch (result){
            case "1":
                OpenWeatherMapProvider.currentForecast(cityName);
                break;
            case "2":
                OpenWeatherMapProvider.FiveDayForecast(cityName);
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
