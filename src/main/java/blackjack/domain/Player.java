package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

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

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
