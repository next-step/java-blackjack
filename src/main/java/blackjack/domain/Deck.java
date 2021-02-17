package blackjack.domain;

import java.util.Arrays;
import java.util.Collections;

public class Deck extends Cards {

    public Deck() {
        super();
        Arrays.stream(Suit.values()).forEach(this::addCard);
        Collections.shuffle(cards);
    }

    public Deck(boolean isDummy) {
        super();
        Arrays.stream(Suit.values()).forEach(this::addCard);
    }

    private void addCard(Suit suit) {
        Arrays.stream(Denomination.values()).forEach(
            rank -> addCard(new Card(suit, rank))
        );
    }

    public Card popCard() {
        Card card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return card;
    }
}
