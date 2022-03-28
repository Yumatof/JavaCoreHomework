package Homework7;

import java.sql.*;


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
            "forecast_text TEXT NOT NULL,\n" +
            ");";

    String insertWeatherQuery = "INSERT INTO weather (city, date_time, forecast_text) VALUES (?,?,?)";

    public void createTable() {
        try (Connection connection = getConnection()) {
            Statement stmt = connection.createStatement();
            performDropTable(stmt);
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:ForecastFiveDay.db");
        return connection;
    }
    private void performDropTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS ForecastFiveDay");
    }

    public void insertForecast(String city, String date, String forecast) throws SQLException {
        try (Connection connection = getConnection();
            PreparedStatement saveForecast = connection.prepareStatement(insertWeatherQuery)) {
            saveForecast.setString(1, city);
            saveForecast.setString(2, date);
            saveForecast.setString(3, forecast);

            saveForecast.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String selectForecast(String date){
       try (Connection connection = getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery
                    ("SELECT forecast FROM ForecastFiveDay WHERE date_time = " + date );
            return resultSet.getString(1);
        }catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }


}


