package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static List<Card> cards = new ArrayList<>();

    public Deck(final List<Card> cards) {
        Deck.cards = cards;
    }

    public static Deck createInitializingCards() {
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

    public void shuffleCards() {
        Collections.shuffle(cards);
    }
}
