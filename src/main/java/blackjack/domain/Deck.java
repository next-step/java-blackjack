package blackjack.domain;

import java.util.Collections;

public class Deck extends Cards {

    public Deck(Boolean shuffle) {
        super();
        for (Suit suit : Suit.values()) {
            add13Rank(suit);
        }
        if (shuffle) {
            Collections.shuffle(cardList);
        }
    }

    private void add13Rank(Suit suit) {
        for (Denomination rank : Denomination.values()) {
            addCard(new Card(suit, rank));
        }
    }

    public Card popCard() {
        Card card = cardList.get(cardList.size() - 1);
        cardList.remove(cardList.size() - 1);
        return card;
    }
}
