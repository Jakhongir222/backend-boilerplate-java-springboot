package co.devskills.springbootboilerplate.sqlite;

import org.springframework.web.client.RestTemplate;

public class AssessedIncomeDetails {
    RestTemplate restTemplate = new RestTemplate();
    String[] ssns = {"424-11-9327", "553-25-8346", "287-54-7823"};
    String creditDataBaseUrl = "https://infra.devskills.app/credit-data/api/1.0.0";

    AssessedIncomeDetails assessedIncomeDetails = restTemplate.getForObject(
            creditDataBaseUrl + "/assessed-income/" + ssns,
            AssessedIncomeDetails.class
    );
}
