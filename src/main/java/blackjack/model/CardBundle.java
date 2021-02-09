package blackjack.model;

import java.util.List;

public class CardBundle {

    private final List<Card> cards;

    public CardBundle(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public static CardBundle of(List<Card> cards) {
        return new CardBundle(cards);
    }
}
