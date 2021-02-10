package blackjack.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private static LinkedList<Card> cards;

    public Deck(final LinkedList<Card> cards) {
        Deck.cards = cards;
    }

    public static Deck createShuffledCards() {
        cards = new LinkedList<>();
        for (final Denomination denomination : Denomination.values()) {
            for (final Suit suit : Suit.values()) {
                cards.add(new Card(denomination, suit));
            }
        }
        return new Deck(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    private static void shuffleCards() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.pop();
    }
}
