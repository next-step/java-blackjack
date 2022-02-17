package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {

    private final List<Card> cardDeck;

    public CardDeck() {
        cardDeck = initDeck();
    }

    public List<Card> initDeck() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Denomination denomination : Denomination.values()) {
                deck.add(new Card(suit, denomination));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public Card popCard() {
        int target = cardDeck.size() - 1;
        Card card = cardDeck.get(target);
        cardDeck.remove(target);

        return card;
    }

    public boolean contains(Card target) {
        return cardDeck.contains(target);
    }
}
