package blackjack.domain;

public class Dealer extends Person {
    private static final Integer REQUEST_LIMIT = 17;
    private static final String DEALER_NAME = "딜러";

    public Dealer() {
        super(DEALER_NAME);
    }

    public Dealer(CardBunch cardBunch) {
        super(DEALER_NAME, cardBunch);
    }

    @Override
    public void requestCard(Deck deck) {
        while (cardBunch.calcScore() < REQUEST_LIMIT) {
            cardBunch.drawCard(deck);
        }
    }
}
