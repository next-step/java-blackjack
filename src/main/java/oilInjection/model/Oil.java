package oilInjection.model;

public class Oil {
    private final double amount;

    private Oil(double amount) {
        this.amount = amount;
        validate();
    }

    public double getAmount() {
        return amount;
    }

    public static Oil of(double amount) {
        return new Oil(amount);
    }

    private void validate(){
        if(amount < 0) {
            throw new IllegalArgumentException("연료의 양은 0보다 작을 수 없습니다");
        }
    }
}
