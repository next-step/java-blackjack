package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        setupCard();
        shuffle();
    }

    private void setupCard() {
        for (Suit suit : Suit.values()) {
            setDenomination(suit);
        }
    }

    private void setDenomination(Suit suit) {
        for (Denomination denomination : Denomination.values()) {
            cards.add(new Card(suit, denomination));
        }
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public Card popCard() {
        Card popped = cards.remove(0);
        return new Card(popped.getSuit(), popped.getDenomination());
    }

    public int getCardsCount() {
        return cards.size();
    }
}
