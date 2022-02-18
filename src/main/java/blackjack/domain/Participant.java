package blackjack.domain;

import java.util.ArrayList;

abstract public class Participant {

    private static final String COLON = " : ";

    protected final String name;
    protected final ParticipantCards cards;
    protected int winScore, loseScore;

    public Participant(String name, ParticipantCards cards, int winCount, int loseCount) {
        this.name = name;
        this.cards = cards;
        this.winScore = winCount;
        this.loseScore = loseCount;
    }

    public Participant(String name) {
        this(name, new ParticipantCards(new ArrayList<>()), 0, 0);
    }

    public final void judgeScore(int maxScore) {
        if (sumCardScore() == maxScore) {
            winScore++;
            return;
        }
        loseScore++;
    }

    public final String getName() {
        return name;
    }

    public final String holdingInfo() {
        return name + COLON + cards.toString();
    }

    public final int sumCardScore() {
        return cards.sumCardScore();
    }

    public abstract void drawCardMultiple(Deck deck, int number);

    public abstract void drawCardContinue(Deck deck);

    public abstract String scoreResult();
}
