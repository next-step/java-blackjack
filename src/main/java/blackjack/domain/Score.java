package blackjack.domain;

import java.util.Objects;

public class Score {

    private final Integer score;

    public Score(Integer score) {
        this.score = score;
    }

    public boolean isBigger(Score maxScore) {
        return maxScore.score < score;
    }

    public boolean isSmaller(Score minScore) {
        return minScore.score > score;
    }

    public Score add(Integer weight) {
        return new Score(score + weight);
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score1 = (Score) o;
        return Objects.equals(score, score1.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }
}
