package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int TEN = 10;
    private static final int BUST_THRESHOLD = 21;

    protected String name;
    protected List<Card> cards;

    public Player(final String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    protected int calculateScore() {
        int score = cards.stream().mapToInt(card -> card.getDenomination().getCount()).sum();
        long aceCount = cards.stream().filter(card -> card.getDenomination().isAce()).count();
        for (int i = 0; i < aceCount; i++) {
            score = adjustScore(score);
        }
        return score;
    }

    private int adjustScore(int score) {
        if (score + TEN <= BUST_THRESHOLD) {
            score += TEN;
        }
        return score;
    }

    protected void receiveCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }


}
