package co.devskills.springbootboilerplate.sqlite;

import org.springframework.web.client.RestTemplate;

public class DebtDetails {

    RestTemplate restTemplate = new RestTemplate();
    String creditDataBaseUrl = "https://infra.devskills.app/credit-data/api/1.0.0";

    DebtDetails debtDetails = restTemplate.getForObject(
            creditDataBaseUrl + "/debt/" + "424-11-9327",
            DebtDetails.class
    );

}
