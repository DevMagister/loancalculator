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
        return null;
    }
}
