package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Deck {

    private final Queue<Card> deck;

    public Deck(List<Card> cards) {
        this.deck = new LinkedList<>(cards);
    }

    public List<Card> cards() {
        return Collections.unmodifiableList(new ArrayList<>(deck));
    }

    public Card spreadCard() {
        return deck.poll();
    }
}
