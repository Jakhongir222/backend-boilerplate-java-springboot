package co.devskills.springbootboilerplate.sqlite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CreditDataController {

    @Autowired
    private final CreditDataService creditDataService;

    public CreditDataController(CreditDataService creditDataService) {
        this.creditDataService = creditDataService;
    }

    @GetMapping("/credit-data/{ssn}")
    public CreditData getCreditData(@PathVariable String ssn) {
        return creditDataService.getCreditData(ssn);
    }
}


