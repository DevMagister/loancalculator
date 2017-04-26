package net.alexfield.loancalculator.calculators;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;

public class EquityLoanCalculatorTest
{
    @Test
    public void testEquityLoanCalculator() {

        /* Create Loan Terms */
        LoanTerms loanTerms = new LoanTerms(120, 50000, BigDecimal.valueOf(8));

        /* Calculate Loan Details */
        LoanDetails loanDetails = new EquityLoanCalculator(loanTerms).getLoanDetails();

        assertThat(loanDetails.getMonthlyPayment(), is("$458.33"));
    }
}