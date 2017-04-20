package net.alexfield.loancalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AbstractLoanCalculator {

    private int numMonths;

    private int loanAmount;

    public int getNumMonths() {
        return numMonths;
    }

    public void setNumMonths(int numMonths) {
        this.numMonths = numMonths;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    private BigDecimal interest;

    public AbstractLoanCalculator(int numMonths, int loanAmount, BigDecimal interest) {
        this.numMonths = numMonths;
        this.loanAmount = loanAmount;
        this.interest = interest;
    }

    protected BigDecimal calculateBaseMonthlyPayment() {
        return new BigDecimal(loanAmount / numMonths);
    }

    protected BigDecimal calculateEvenlyDispersedInterestPayments() {
        return new BigDecimal(loanAmount).multiply(interest.movePointLeft(2)).divide(new BigDecimal(numMonths), RoundingMode.UP);
    }

    public abstract LoanDetails getLoanPayments();
}
