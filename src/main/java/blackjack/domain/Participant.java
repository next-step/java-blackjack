package blackjack.domain;

import java.util.ArrayList;

abstract public class Participant {
    protected final String name;
    protected final Cards cards;
    protected final int winCount, loseCount;

    public Participant(String name, Cards cards, int winCount, int loseCount) {
        this.name = name;
        this.cards = cards;
        this.winCount = winCount;
        this.loseCount = loseCount;
    }

    public Participant(String name) {
        this(name, new Cards(new ArrayList<>()), 0, 0);
    }

    abstract void drawCard(int number);
}
