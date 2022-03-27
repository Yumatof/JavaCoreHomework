package Homework7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class ForecastFiveDayDatabaseSQLite {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    String createTableQuery = "CREATE TABLE IF NOT EXISTS ForecastFiveDay (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            ");";



    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:ForecastFiveDay.db");
        return connection;
    }
    private void performDropTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS ForecastFiveDay");
    }
}


