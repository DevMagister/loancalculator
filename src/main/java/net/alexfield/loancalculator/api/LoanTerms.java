package net.alexfield.loancalculator.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import net.alexfield.loancalculator.calculators.LoanType;

import java.math.BigDecimal;

/**
 * This class is a set of Loan Terms that the Loan Calculator will used to calculate monthly payments.
 */
@Getter
@NoArgsConstructor
public class LoanTerms {

    /** Number of Months this loan is for */
    private int numMonths;

    /** Total Loan Amount */
    private int loanAmount;

    /** Total interest for this Loan */
    private BigDecimal interest;

    /** Type of Loan */
    private LoanType type;

    /**
     * Creates a new Loan Terms with the given number of months, loan amount, and interest
     *
     * @param numMonths  number of months until this loan matures
     * @param loanAmount total amount to be borrowed
     * @param interest   interest on the loan
     */
    public LoanTerms(int numMonths, int loanAmount, BigDecimal interest) {

        this.numMonths = numMonths;
        this.loanAmount = loanAmount;
        this.interest = interest;
    }
}
