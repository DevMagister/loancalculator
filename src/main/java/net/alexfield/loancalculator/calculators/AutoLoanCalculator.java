package net.alexfield.loancalculator.calculators;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;

import java.math.BigDecimal;

/**
 * This calculator will calculate the loan details for Auto Loans which contain a 1% processing fee each month
 */
public class AutoLoanCalculator extends AbstractLoanCalculator {

    /** Processing Fee Percentage */
    private static final BigDecimal FEE_PERCENTAGE = new BigDecimal(.01);

    /**
     * Create an new Auto Loan Calculator with the given terms to be used for Loan Detail calculations
     *
     * @param loanTerms loan terms to use for monthly calculations
     */
    public AutoLoanCalculator(LoanTerms loanTerms) {
        super(loanTerms.getNumMonths(), loanTerms.getLoanAmount(), loanTerms.getInterest());
    }

    @Override
    public LoanDetails calculateLoanDetails() {

        /* Calculate Monthly Base Payment */
        BigDecimal monthlyBase = calculateBaseMonthlyPayment();

        /* Calculate Monthly Interest Payment */
        BigDecimal monthlyInterest = calculateEvenlyDispersedInterestPayments();

        /* Calculate Monthly Transaction Fee */
        BigDecimal monthlyTransactionFee = calculateMonthlyFee();

        /* Calculate Monthly Payment */
        BigDecimal monthlyPayment = monthlyBase.add(monthlyInterest).add(monthlyTransactionFee);

        return new LoanDetails(LoanType.AUTO, monthlyPayment);
    }

    /**
     * Calculate the Monthly Fee amount base on this loans details
     *
     * @return Monthly fee amount in dollars
     */
    private BigDecimal calculateMonthlyFee() {
        return getLoanAmount().multiply(FEE_PERCENTAGE)
                .divide(BigDecimal.valueOf(getNumMonths()), BigDecimal.ROUND_HALF_UP);
    }
}
