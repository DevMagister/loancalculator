package net.alexfield;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", consumes = {"application/json"}, produces = {"application/json"})
public class LoanCalculatorController {

    @RequestMapping(value = "/loan-calculator", produces = {"application/text"})
    public String getGreeting() {
        return "Why yes, I am the Loan Calculator! Thanks for visiting!";
    }
}
