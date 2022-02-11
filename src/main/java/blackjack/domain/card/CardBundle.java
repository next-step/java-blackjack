package blackjack.domain.card;

import java.util.ArrayList;
import java.util.List;

public class CardBundle {

    public List<Card> createCards() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            createBySuit(cards, suit);
        }
        return cards;
    }

    private void createBySuit(List<Card> cards, Suit suit) {
        for (Number number : Number.values()) {
            cards.add(new Card(suit, number));
        }
    }
}
