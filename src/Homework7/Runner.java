package Homework7;

import java.io.IOException;
import java.sql.SQLException;

public class Runner {
    public static void main (String []args) throws IOException, SQLException {
        UserInterface userInterface = new UserInterface();
        userInterface.runApplication();
    }
}

