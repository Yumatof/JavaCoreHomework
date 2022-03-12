package Homework7;



import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private final Controller controller = new Controller();

    public void runApplication() throws IOException {
        while(true){
            System.out.print("Введите название города в котором Вам нужно узнать погоду > ");
            String cityName = scanner.nextLine();

            System.out.print("\nВыберите тип прогноза:\n " +
                    " - введите 1 если Вам нужен прогноз на сегодня;\n" +
                    " - введите 2 если Вам нужен прогноз на ближайшие 5 дней(прогноз будет выводиться с разбивкой на 3 часовой интревал);\n" +
                    " - введите 0 для выхода из приложения\n > ");
            String result = scanner.nextLine();

            try {
                validateInputValue(result);
            }catch (IOException e){
                e.printStackTrace();
            }
            controller.UserInput(cityName, result);
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

