package BlackJack;

public enum CardNumber {
    ACE(1, 11), TWO(2), THREE(3), FOUR(4), FIVE(5),
    SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10);

    private int score;
    private int minScore;
    private int maxScore;

    CardNumber(int score) {
        this.score = score;
    }

    CardNumber(int minScore, int maxScore) {
        this.score = score;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public int getMinScore() {
        return minScore;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getScore() {
        return score;
    }
}
