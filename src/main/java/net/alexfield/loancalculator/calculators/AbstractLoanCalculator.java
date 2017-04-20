package net.alexfield.loancalculator.calculators;

import net.alexfield.loancalculator.api.LoanDetails;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractLoanCalculator {

    private int numMonths;
    private BigDecimal loanAmount;
    private BigDecimal interest;

    public AbstractLoanCalculator(int numMonths, int loanAmount, BigDecimal interest) {
        this.numMonths = numMonths;
        this.loanAmount = new BigDecimal(loanAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.interest = interest;
    }

    public int getNumMonths() {
        return numMonths;
    }

    public void setNumMonths(int numMonths) {
        this.numMonths = numMonths;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    protected BigDecimal calculateBaseMonthlyPayment() {
        return loanAmount.divide(BigDecimal.valueOf(numMonths), RoundingMode.HALF_UP);
    }

    protected BigDecimal calculateEvenlyDispersedInterestPayments() {
        return loanAmount.multiply(interest.movePointLeft(2)).setScale(2, RoundingMode.HALF_UP)
                .divide(new BigDecimal(numMonths), RoundingMode.HALF_UP);
    }

    public abstract LoanDetails getLoanPayments();
}
