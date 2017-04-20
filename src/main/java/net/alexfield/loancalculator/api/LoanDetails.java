package net.alexfield.loancalculator.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.alexfield.loancalculator.calculators.LoanType;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * This class represents the JSON format that is return from the Loan Calculator.
 */
public class LoanDetails {

    /** Money Formatter */
    @JsonIgnore
    private static DecimalFormat moneyFormat = new DecimalFormat("$#,###.00");

    /** Type of Loan */
    private LoanType type;

    /** Dollar amount of Monthly Payments */
    private BigDecimal monthlyPayment;

    /**
     * Default Constructor - Bean required for Jackson Serialization
     */
    public LoanDetails() {
        /* Bean - Default Constructor */
    }

    /**
     * Creates new <code>LoanDetails</code> with the given type and monthly payment.
     *
     * @param type           type of loan
     * @param monthlyPayment monthly payment of this loan
     */
    public LoanDetails(LoanType type, BigDecimal monthlyPayment) {
        this.type = type;
        this.monthlyPayment = monthlyPayment;
    }

    /**
     * Returns the type of loan <i>this</i> is.
     *
     * @return this loans type
     */
    public LoanType getType() {

        return type;
    }

    /**
     * Sets the type of loan this loan is.
     *
     * @param type loan type
     */
    public void setType(LoanType type) {
        this.type = type;
    }

    /**
     * Returns this loans monthly payment in the Dollar format (i.e $##.##)
     *
     * @return monthly payment in dollars
     */
    public String getMonthlyPayment() {
        return moneyFormat.format(monthlyPayment);
    }

    /**
     * Sets this loan's monthly payment
     *
     * @param monthlyPayment monthly payment for this loan
     */
    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
