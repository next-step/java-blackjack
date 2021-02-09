package blackjack.domain;

public class Dealer extends Person {
    private static final Integer REQUEST_LIMIT = 17;
    private static final String DEALER_NAME = "딜러";

    public Dealer(CardBunch cardBunch) {
        super(DEALER_NAME, cardBunch);
    }
}
