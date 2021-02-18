package blackjack.model;

public class Money {

    private final int MONEY_LOW_BOUND = 0;
    private int money;

    private Money(int money) {
        validate(money);
        this.money = money;
    }

    public void validate(int money) {

        if (money < MONEY_LOW_BOUND) {
            throw new IllegalArgumentException("보유 금액은 0 미만이 될 수 없습니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    public static Money of(int money) {
        return new Money(money);
    }
}
