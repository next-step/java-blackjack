package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards() {
        this.cards = new ArrayList<>();
    }

    public Cards (List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Integer getSize() {
        return cards.size();
    }

    public void push(Card card) {
        this.cards.add(card);
    }
}
