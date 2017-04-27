package net.alexfield.loancalculator.api;

import net.alexfield.loancalculator.calculators.AutoLoanCalculator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the controller for the Loan Calculators Restful endpoints.
 */
@RestController
@RequestMapping(value = "/")
public class LoanCalculatorController {

    /**
     * This endpoint is really just a test end point to make sure the Loan Calculator is ready to calculate.
     *
     * @return Loan Calculator Greeting
     */
    @RequestMapping(value = "/loan-calculator", method = RequestMethod.GET, produces = {"text/plain"})
    public String getGreeting() {
        return "Why yes, I am the Loan Calculator! Thanks for visiting!";
    }

    /**
     * This methods is the endpoint for POST into the calculator that will be requesting monthly payment information.
     *
     * @param loanTerms Loan Terms from which to calculate Loan Details.
     * @return Calculated loan details.
     */
    @RequestMapping(value = "/loan-calculator", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public LoanDetails getMonthlyPayment(@RequestBody LoanTerms loanTerms) {

        switch (loanTerms.getType()) {
            case AUTO:
                return new AutoLoanCalculator(loanTerms).calculateLoanDetails();
            default:
                return null;
        }
    }
}
