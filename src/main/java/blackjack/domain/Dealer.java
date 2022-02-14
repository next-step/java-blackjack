package blackjack.domain;

import java.util.List;

public class Dealer {

    private static final String DEALER = "딜러";

    private final String name;
    private int score;
    private List<Card> cards;

    public Dealer(int score, List<Card> cards) {
        this.name = DEALER;
        this.score = score;
        this.cards = cards;
    }

    public void addCard(final Card card) {
        score += card.getPoint();
        this.cards.add(card);
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
