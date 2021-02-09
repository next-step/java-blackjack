package oilInjection.model;

public class Oil {
    private final double amount;

    private Oil(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public static Oil of(double amount) {
        return new Oil(amount);
    }
}
