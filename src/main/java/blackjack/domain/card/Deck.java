package blackjack.domain.card;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Deck {

    private final Queue<Card> deck;

    public Deck(List<Card> cards) {
        this.deck = new LinkedList<>(cards);
    }

    public Card spreadCard() {
        return deck.poll();
    }

    public int remainCardSize() {
        return deck.size();
    }
}
