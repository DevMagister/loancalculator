package net.alexfield.loancalculator.calculators;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;

import java.math.BigDecimal;

public class AutoLoanCalculator extends AbstractLoanCalculator {

    private static final BigDecimal FEE_PERCENTAGE = new BigDecimal(.01);

    public AutoLoanCalculator(LoanTerms loanTerms) {
        super(loanTerms.getNumMonths(), loanTerms.getLoanAmount(), loanTerms.getInterest());
    }

    @Override
    public LoanDetails getLoanDetails() {

        /* Calculate Monthly Base Payment */
        BigDecimal monthlyBase = calculateBaseMonthlyPayment();

        /* Calculate Monthly Interest Payment */
        BigDecimal monthlyInterest = calculateEvenlyDispersedInterestPayments();

        /* Calculate Monthly Transaction Fee */
        BigDecimal monthlyTransactionFee = getMonthlyFee();

        /* Calculate Monthly Payment */
        BigDecimal monthlyPayment = monthlyBase.add(monthlyInterest).add(monthlyTransactionFee);

        return new LoanDetails(LoanType.AUTO, monthlyPayment);
    }

    private BigDecimal getMonthlyFee() {
        return getLoanAmount().multiply(FEE_PERCENTAGE)
                .divide(BigDecimal.valueOf(getNumMonths()), BigDecimal.ROUND_HALF_UP);
    }
}
