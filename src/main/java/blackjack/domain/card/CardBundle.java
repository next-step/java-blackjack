package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardBundle {

    public List<Card> createCards() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            createBySuit(cards, suit);
        }
        Collections.shuffle(cards);
        return cards;
    }

    private void createBySuit(List<Card> cards, Suit suit) {
        for (Number number : Number.values()) {
            cards.add(new Card(suit, number));
        }
    }
}
