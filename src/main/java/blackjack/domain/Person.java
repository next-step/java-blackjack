package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    protected List<Card> cards;

    protected void initTwoCards(Card card1, Card card2) {
        cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
    }

    protected void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
