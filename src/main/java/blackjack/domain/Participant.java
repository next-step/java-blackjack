package blackjack.domain;

import java.util.ArrayList;

public abstract class Participant {

    private static final int SCORE_CRITERIA = 21;

    protected final String name;
    protected final Cards cards;
    protected int winScore;
    protected int loseScore;

    Participant(String name, Cards cards, int winCount, int loseCount) {
        this.name = name;
        this.cards = cards;
        this.winScore = winCount;
        this.loseScore = loseCount;
    }

    Participant(String name) {
        this(name, new Cards(new ArrayList<>()), 0, 0);
    }

    public final void judgeScore(int crieriaScore) {
        int userScore = sumCardScore() - SCORE_CRITERIA;
        if (userScore == crieriaScore) {
            winScore++;
            return;
        }
        loseScore++;
    }

    public final int sumCardScore() {
        return cards.sumCardScore();
    }

    public abstract boolean drawCardMultiple(Deck deck, int number);

    public final String getName() {
        return name;
    }

    public final Cards getCards() {
        return cards;
    }

    public int getWinScore() {
        return winScore;
    }

    public int getLoseScore() {
        return loseScore;
    }
}
