package blackJack.domain;

import java.util.List;

public class Dealer implements User {

    private static final String DEALER_DEFAULT_NAME = "딜러";
    private static final int ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD = 16;

    private final Deck deck;
    private final UserName userName;

    private Dealer() {
        this.deck = Deck.create();
        this.userName = UserName.from(DEALER_DEFAULT_NAME);
    }

    public static Dealer create() {
        return new Dealer();
    }

    public List<Card> getDeck() {
        return deck.getDeck();
    }

    public String getName() {
        return userName.getName();
    }

    public void appendToDeck(Card card) {
        deck.append(card);
    }

    public void appendToDeck(List<Card> cards) {
        cards.forEach(deck::append);
    }

    public boolean isCardDraw() {
        return deck.getScore() <= ADDITIONAL_CARD_DRAW_SCORE_THRESHOLD;
    }

    public void additionalCardDraw(Card card) {
        appendToDeck(card);
    }

    public String convertStatus() {
        return String.format("%s 카드: %s", userName.getName(), deck.convertDeckFormat());
    }

    public int getScore() {
        return deck.getScore();
    }
}
