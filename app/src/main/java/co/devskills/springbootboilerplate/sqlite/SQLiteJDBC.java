package co.devskills.springbootboilerplate.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:credit_data.db");
            System.out.println("Opened database successfully");

            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS credit_data " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " first_name TEXT, " +
                    " last_name TEXT, " +
                    " address TEXT, " +
                    " assessed_income INT, " +
                    " balance_of_debt INT, " +
                    " complaints BOOLEAN)";
            statement.executeUpdate(sql);
            statement.close();

            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }
}

