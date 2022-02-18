package blackjack.domain.person;

import blackjack.domain.card.Card;
import java.util.ArrayList;
import java.util.List;

public abstract class Person {

    protected List<Card> cards = new ArrayList<>();
    protected int sum;

    public abstract void addCard(Card card);

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}
