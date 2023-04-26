package co.devskills.springbootboilerplate.sqlite;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditDataService {

    private RestTemplate restTemplate;
    private String creditDataBaseUrl;

    public CreditDataService() {
        this.restTemplate = new RestTemplate();
        this.creditDataBaseUrl = "https://infra.devskills.app/credit-data/api/1.0.0";
    }

    public CreditData getCreditData(String ssn) {
        PersonalDetails personalDetails = restTemplate.getForObject(
                creditDataBaseUrl + "/personal-details/" + ssn,
                PersonalDetails.class
        );

        AssessedIncomeDetails assessedIncomeDetails = restTemplate.getForObject(
                creditDataBaseUrl + "/assessed-income/" + ssn,
                AssessedIncomeDetails.class
        );

        DebtDetails debtDetails = restTemplate.getForObject(
                creditDataBaseUrl + "/debt/" + ssn,
                DebtDetails.class
        );

        CreditData creditData = new CreditData();
        creditData.setFirstName(creditData.getFirstName());
        creditData.setLastName(creditData.getLastName());
        creditData.setAddress(creditData.getAddress());
        creditData.setAssessedIncome(creditData.getAssessedIncome());
        creditData.setBalanceOfDebt(creditData.getBalanceOfDebt());
        creditData.setComplaints(creditData.isComplaints());

        return creditData;
    }

}

