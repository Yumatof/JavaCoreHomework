package Homework7.MyException;

public class InvalidDateException extends Exception {
    public InvalidDateException(){
        super("Something went wrong and you have chosen a day and time for which there is no forecast yet.");
    }
}

