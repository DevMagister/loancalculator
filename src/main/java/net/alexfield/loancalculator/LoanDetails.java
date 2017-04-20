package net.alexfield.loancalculator;

import java.math.BigDecimal;

public class LoanDetails {

    private LoanType type;

    private String monthlyPayment;

    public LoanDetails() {
    }

    public LoanDetails(LoanType type, String monthlyPayment) {

        this.type = type;
        this.monthlyPayment = monthlyPayment;
    }

    public LoanType getType() {

        return type;
    }

    public void setType(LoanType type) {
        this.type = type;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
