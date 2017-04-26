package net.alexfield.loancalculator.calculators;

import java.math.BigDecimal;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;

public class HomeLoanCalculator extends AbstractLoanCalculator
{
    /**
     * Creates a new Abstract Loan Calculator with the below given values to use during calculation.
     */
    public HomeLoanCalculator(LoanTerms loanTerms)
    {
        super(loanTerms.getNumMonths(), loanTerms.getLoanAmount(), loanTerms.getInterest());
    }

    @Override
    public LoanDetails getLoanDetails()
    {
        /* Get Base Monthly Payment */
        BigDecimal basePayment = calculateBaseMonthlyPayment();

        /* Get Interest Monthly Payment */
        BigDecimal interestPayment = calculateEvenlyDispersedInterestPayments();

        /* Calculate Monthly Payment */
        BigDecimal monthlyPayment = basePayment.add(interestPayment);

        return new LoanDetails(LoanType.HOME, monthlyPayment);
    }
}
