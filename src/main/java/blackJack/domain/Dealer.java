package blackJack.domain;

public class Dealer extends User {

    private static final String DEALER_DEFAULT_NAME = "딜러";
    private static final int ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD = 16;

    private Dealer() {
        super(Deck.create(), UserName.from(DEALER_DEFAULT_NAME));
    }

    public static Dealer create() {
        return new Dealer();
    }

    public boolean isCardDraw() {
        return deck.getScore() <= ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD;
    }

    public void additionalCardDraw(Card card) {
        appendToDeck(card);
    }
}
