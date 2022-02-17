package blackjack.domain;

import java.util.ArrayList;

abstract public class Participant {

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
        if(sumCardScore() == maxScore){
            winScore++;
            return;
        }
        loseScore++;
    }

    public final int sumCardScore() {
        return cards.sumCardScore();
    }

    public abstract void drawCardMultiple(Deck deck, int number);
}
