package Homework7.MyException;

public class EmptyDataBaseException extends Exception{
    public EmptyDataBaseException (){
        super("Вы пытаетесь обратиться к пустой базе данных.\n" +
              "Пожаолуйста, сделайте запрос погоды на ближайшие 5 дней и повторите свои действия.");
    }
}
