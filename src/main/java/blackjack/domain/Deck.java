package blackjack.domain;

import java.util.Collections;

public class Deck extends Cards {

    public Deck() {
        super();
        for (Suit suit : Suit.values()) {
            for (Denomination rank : Denomination.values()) {
                addCard(new Card(suit, rank));
            }
        }
        Collections.shuffle(cardList);
    }

    public Card popCard() {
        Card card = cardList.get(cardList.size() - 1);
        cardList.remove(cardList.size() - 1);
        return card;
    }
}
