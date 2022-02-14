package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private int score;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.cards = new ArrayList<>();
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
