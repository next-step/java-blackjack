package blackjack.domain.person;

import blackjack.domain.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Person {

    protected List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}
