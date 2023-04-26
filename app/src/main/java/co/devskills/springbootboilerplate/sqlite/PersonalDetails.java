package co.devskills.springbootboilerplate.sqlite;

import org.springframework.web.client.RestTemplate;

public class PersonalDetails {
    RestTemplate restTemplate = new RestTemplate();
    String creditDataBaseUrl = "http://localhost:8080/credit-data";

    PersonalDetails personalDetails = restTemplate.getForObject(
            creditDataBaseUrl + "/personal-details/" + "424-11-9327",
            PersonalDetails.class
    );

}
