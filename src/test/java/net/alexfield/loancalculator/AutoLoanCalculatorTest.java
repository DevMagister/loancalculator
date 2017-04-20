package net.alexfield.loancalculator;

import net.alexfield.loancalculator.api.LoanDetails;
import net.alexfield.loancalculator.api.LoanTerms;
import net.alexfield.loancalculator.calculators.AutoLoanCalculator;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AutoLoanCalculatorTest {

    @Test
    public void testAutoLoanCalculator() {

        /* Create Loan Terms */
        LoanTerms loanTerms = new LoanTerms(5, 500, BigDecimal.valueOf(10.0));

        /* Get Loan Details */
        LoanDetails details = new AutoLoanCalculator(loanTerms).getLoanPayments();

        /* Check Values */
        assertThat(details.getMonthlyPayment(), is("$111.00"));
    }

    @Test
    public void testDecimalAutoLoan() {

        /* Create Loan Terms */
        LoanTerms loanTerms = new LoanTerms(12, 500, BigDecimal.valueOf(10.0));

        /* Get Loan Details */
        LoanDetails details = new AutoLoanCalculator(loanTerms).getLoanPayments();

        /* Check Values */
        assertThat(details.getMonthlyPayment(), is("$46.26"));
    }
}