package blackjack.domain;

import java.util.List;

public abstract class Gambler {
    protected String name;
    protected List<Card> cards;

    protected abstract int calculateScore();
    protected abstract void receiveCard();

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }
}
