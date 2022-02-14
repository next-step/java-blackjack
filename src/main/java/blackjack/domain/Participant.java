package blackjack.domain;

import java.util.List;

abstract public class Participant {
    protected final String name;
    protected final List<Card> cards;
    protected final int winCount, loseCount;

    public Participant(String name, List<Card> cards, int winCount, int loseCount) {
        this.name = name;
        this.cards = cards;
        this.winCount = winCount;
        this.loseCount = loseCount;
    }

    abstract void drawCard();
}
