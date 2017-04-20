package net.alexfield.loancalculator;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AutoLoanCalculatorTest {

    @Test
    public void testAutoLoanCalculator() {

        /* Create Loan Terms */
        LoanTerms loanTerms = new LoanTerms(5, 500, new BigDecimal(10.0));

        /* Get Loan Details */
        LoanDetails details = new AutoLoanCalculator(loanTerms).getLoanPayments();

        assertThat(details.getMonthlyPayment(), is("$111.00"));
    }
}