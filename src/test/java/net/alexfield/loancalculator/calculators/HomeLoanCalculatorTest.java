package net.alexfield.loancalculator.calculators;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;

public class HomeLoanCalculatorTest
{
    @Test
    public void testHomeLoanCalculatorTest() {

        /* Create Loan Terms */
        LoanTerms loanTerms = new LoanTerms(360, 100000, BigDecimal.valueOf(5.0));

        LoanDetails loanDetails = new HomeLoanCalculator(loanTerms).getLoanDetails();

        assertThat(loanDetails.getMonthlyPayment(), is("$291.78"));
    }
}