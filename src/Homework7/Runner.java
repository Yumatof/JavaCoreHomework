package Homework7;

import Homework7.MyException.InvalidDateException;

import java.io.IOException;

public class Runner {
    public static void main (String []args) throws IOException, InvalidDateException {
        UserInterface userInterface = new UserInterface();
        userInterface.runApplication();

    }
}

