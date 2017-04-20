package net.alexfield.loancalculator.calculators;

public class Payment {

    private int month;
    private int amount;

    public Payment() {
        /* I'm a Bean - needs default constructor */
    }

    public Payment(int month, int amount) {
        this.month = month;
        this.amount = amount;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
