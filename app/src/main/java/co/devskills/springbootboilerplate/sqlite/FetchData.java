package co.devskills.springbootboilerplate.sqlite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {
    public void FetchingData() {
        try {
            // Create URL object for the API endpoint
            URL url = new URL("https://infra.devskills.app/credit-data/api/1.0.0");

            // Open connection to the API endpoint
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            conn.setRequestMethod("GET");

            // Read the response from the API endpoint
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Print the response from the API endpoint
            System.out.println(response.toString());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
