package co.devskills.springbootboilerplate.sqlite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

public class FetchData {
    public void FetchingData() {
        try {
            // Check if data is already in the database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:path/to/database.db");
            PreparedStatement stmt = conn.prepareStatement("SELECT response FROM credit_data WHERE id = ?");
            stmt.setInt(1, 1); // Use 1 as the primary key value for this example
            ResultSet rs = stmt.executeQuery();
            String response = null;
            if (rs.next()) {
                response = rs.getString("response");
            }
            rs.close();
            stmt.close();
            conn.close();

            if (response == null) {
                // Data is not in the database, fetch it from the API
                URL url = new URL("https://infra.devskills.app/credit-data/api/1.0.0");
                HttpURLConnection conn2 = (HttpURLConnection) url.openConnection();
                conn2.setRequestMethod("GET");
                BufferedReader in = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
                String inputLine;
                StringBuilder responseBuilder = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    responseBuilder.append(inputLine);
                }
                in.close();
                response = responseBuilder.toString();

                // Store data in the database
                Connection conn3 = DriverManager.getConnection("jdbc:sqlite:path/to/database.db");
                PreparedStatement stmt2 = conn3.prepareStatement("INSERT INTO credit_data (id, response) VALUES (?, ?)");
                stmt2.setInt(1, 1); // Use 1 as the primary key value for this example
                stmt2.setString(2, response);
                stmt2.executeUpdate();
                stmt2.close();
                conn3.close();
            }

            System.out.println(response);
        } catch (IOException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
