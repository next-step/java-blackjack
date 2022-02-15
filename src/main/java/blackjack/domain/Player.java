package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

    private static final String ACE = "A";
    private static final int BLACK_JACK = 21;

    private final String name;
    private int score;
    private List<Card> cards;
    private boolean isDealer;

    public Player(String name, boolean isDealer) {
        this.name = name;
        this.score = 0;
        this.cards = new ArrayList<>();
        this.isDealer = isDealer;
    }

    public void receiveCard(Card card) {
        addCard(card);
        addScore(card);
    }

    private void addCard(final Card card) {
        this.cards.add(card);
    }

    private void addScore(final Card card) {
        if (isAceCard(card)) {
            this.score = getBetterPointForAce(card);
            return;
        }
        this.score += card.getPoint();
    }

    private boolean isAceCard(final Card card) {
        return card.getName().equals(ACE);
    }

    private int getBetterPointForAce(Card card) {
        int curScore = this.score;
        if (curScore + card.getPoint() < BLACK_JACK) {
            return curScore + card.getPoint();
        }
        return curScore + card.getLowerAcePoint();
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public boolean isDealer() {
        return this.isDealer;
    }
}
