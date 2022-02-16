package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class CardBundle {

    private final List<Card> cards;

    private CardBundle() {
        this.cards = new ArrayList<>();
    }

    public static CardBundle emptyBundle() {
        return null;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        return 0;
    }
}
