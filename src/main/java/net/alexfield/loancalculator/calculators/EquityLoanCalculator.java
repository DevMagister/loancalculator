package net.alexfield.loancalculator.calculators;

import java.math.BigDecimal;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;

public class EquityLoanCalculator extends AbstractLoanCalculator {

    /** Processing Fee Percentage */
    private static final BigDecimal FEE_PERCENTAGE = new BigDecimal(.02);

    public EquityLoanCalculator(LoanTerms loanTerms) {
        super(loanTerms.getNumMonths(), loanTerms.getLoanAmount(), loanTerms.getInterest());
    }

    @Override
    public LoanDetails calculateLoanDetails()
    {
        /* Get Base Payment */
        BigDecimal baseMonthlyPayment = calculateBaseMonthlyPayment();

        /* Calculate Interest Monthly Payment */
        BigDecimal interestMonthlyPayment = calculateEvenlyDispersedInterestPayments();

        /* Calculate Monthly Fees */
        BigDecimal monthlyFee = calculateMonthlyFee();

        BigDecimal monthlyPayment = baseMonthlyPayment.add(interestMonthlyPayment).add(monthlyFee);

        return new LoanDetails(LoanType.EQUITY, monthlyPayment);
    }

    private BigDecimal calculateMonthlyFee()
    {
        return getLoanAmount().multiply(FEE_PERCENTAGE)
                .divide(BigDecimal.valueOf(getNumMonths()), BigDecimal.ROUND_HALF_UP);
    }
}
