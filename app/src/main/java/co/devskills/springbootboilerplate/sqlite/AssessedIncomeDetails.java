package co.devskills.springbootboilerplate.sqlite;

import org.springframework.web.client.RestTemplate;

public class AssessedIncomeDetails {
    RestTemplate restTemplate = new RestTemplate();
    String creditDataBaseUrl = "http://localhost:8080/credit-data";

    AssessedIncomeDetails assessedIncomeDetails = restTemplate.getForObject(
            creditDataBaseUrl + "/assessed-income/" + "424-11-9327",
            AssessedIncomeDetails.class
    );
}
