package blackjack;

import java.util.List;

public class Cards {

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int totalScore() {
        return cards.stream().mapToInt(Card::getCardScore).sum();
    }
}
