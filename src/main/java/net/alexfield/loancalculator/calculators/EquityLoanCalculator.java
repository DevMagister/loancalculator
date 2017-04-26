package net.alexfield.loancalculator.calculators;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;

public class EquityLoanCalculator extends AbstractLoanCalculator
{
    public EquityLoanCalculator(LoanTerms loanTerms) {
        super(loanTerms.getNumMonths(), loanTerms.getLoanAmount(), loanTerms.getInterest());
    }

    @Override
    public LoanDetails getLoanDetails()
    {
        return null;
    }
}
