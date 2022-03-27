package Homework7.MyException;

public class EmptyDataBaseException extends Exception{
    public EmptyDataBaseException (){
        super("You are trying to access an empty database.\n" +
              "Please make a weather request for the next 5 days and repeat your steps.");
    }
}
