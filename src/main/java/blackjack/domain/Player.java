package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    protected String name;
    protected List<Card> cards;

    public Player(final String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    protected int calculateScore() {
        return 0;
    }
    protected void receiveCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }


}
