package co.devskills.springbootboilerplate.sqlite;

import org.springframework.web.client.RestTemplate;

public class DebtDetails {

    RestTemplate restTemplate = new RestTemplate();
    String creditDataBaseUrl = "http://localhost:8080/credit-data";

    DebtDetails debtDetails = restTemplate.getForObject(
            creditDataBaseUrl + "/debt/" + "424-11-9327",
            DebtDetails.class
    );

}
