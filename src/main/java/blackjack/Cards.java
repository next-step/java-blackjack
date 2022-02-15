package blackjack;

import java.util.List;

public class Cards {

    private static final int REFERENCE_POINT = 21;
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int totalScore() {
        return cards.stream().mapToInt(Card::getCardScore).sum();
    }

    public boolean isNearTwentyOne() {
        return totalScore() < REFERENCE_POINT;
    }
}
