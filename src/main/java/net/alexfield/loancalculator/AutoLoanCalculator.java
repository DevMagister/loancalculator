package net.alexfield.loancalculator;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class AutoLoanCalculator extends AbstractLoanCalculator {

    public AutoLoanCalculator(LoanTerms loanTerms) {
        super(loanTerms.getNumMonths(), loanTerms.getLoanAmount(), loanTerms.getApr());
    }

    private static DecimalFormat moneyFormat = new DecimalFormat("$#,###.00");

    @Override
    public LoanDetails getLoanPayments() {

        /* Calculate Monthly Base Payment */
        BigDecimal monthlyBase = calculateBaseMonthlyPayment();

        /* Calculate Monthly Interest Payment */
        BigDecimal monthlyInterest = calculateEvenlyDispersedInterestPayments();

        /* Calculate Monthly Transaction Fee */
        BigDecimal monthlyTransactionFee = new BigDecimal(getLoanAmount() * .01 / getNumMonths());

        /* Calculate Monthly Payment */
        BigDecimal monthlyPayment = monthlyBase.add(monthlyInterest).add(monthlyTransactionFee);

        return new LoanDetails(LoanType.AUTO, moneyFormat.format(monthlyPayment));
    }
}
