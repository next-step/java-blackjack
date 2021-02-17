package blackjack.domain;

import java.util.Objects;

public class Score {

    private final Integer score;

    public Score(Integer score) {
        this.score = score;
    }

    public Integer getValue() {
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
