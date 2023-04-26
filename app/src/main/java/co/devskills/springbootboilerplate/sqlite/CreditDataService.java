package co.devskills.springbootboilerplate.sqlite;

import org.springframework.web.client.RestTemplate;

public class CreditDataService {

    private RestTemplate restTemplate;
    private String creditDataBaseUrl;

    public CreditDataService() {
        this.restTemplate = new RestTemplate();
        this.creditDataBaseUrl = "https://credit-data-api.com";
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

    public static void main(String[] args) {
        CreditDataService creditDataService = new CreditDataService();
        String[] ssns = {"424-11-9327", "553-25-8346", "287-54-7823"};
        for (String ssn : ssns) {
            CreditData creditData = creditDataService.getCreditData(ssn);
            System.out.println(creditData);
        }
    }
}

