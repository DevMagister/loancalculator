package net.alexfield.loancalculator;

import java.math.BigDecimal;

public class LoanTerms {

    private int numMonths;
    private int loanAmount;
    private BigDecimal apr;
    private LoanType type;

    public LoanTerms() {
    }

    public LoanTerms(int numMonths, int loanAmount, BigDecimal apr) {

        this.numMonths = numMonths;
        this.loanAmount = loanAmount;
        this.apr = apr;
    }

    public LoanType getType() {
        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

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

    public BigDecimal getApr() {
        return apr;
    }

    public void setApr(BigDecimal apr) {
        this.apr = apr;
    }
}
