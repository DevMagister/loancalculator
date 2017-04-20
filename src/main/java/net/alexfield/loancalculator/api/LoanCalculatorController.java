package net.alexfield.loancalculator.api;

import net.alexfield.loancalculator.calculators.AutoLoanCalculator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class LoanCalculatorController {

    @RequestMapping(value = "/loan-calculator", method = RequestMethod.GET, produces = {"text/plain"})
    public String getGreeting() {
        return "Why yes, I am the Loan Calculator! Thanks for visiting!";
    }

    @RequestMapping(value = "/loan-calculator", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public LoanDetails getMonthlyPayment(@RequestBody LoanTerms loanTerms) {

        switch (loanTerms.getType()) {
            case AUTO:
                return new AutoLoanCalculator(loanTerms).getLoanPayments();
            default:
                return null;
        }
    }
}
