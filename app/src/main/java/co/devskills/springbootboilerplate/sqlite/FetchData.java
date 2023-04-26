package co.devskills.springbootboilerplate.sqlite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {
    public void FetchingData() {
        try {
            URL url = new URL("https://infra.devskills.app/credit-data/api/1.0.0");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
