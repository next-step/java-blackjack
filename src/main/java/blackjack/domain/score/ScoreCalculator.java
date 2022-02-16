package blackjack.domain.score;

import blackjack.domain.card.Card;
import java.util.Arrays;
import java.util.List;

public enum ScoreCalculator {

    ACE(new AceScoreStrategy()),
    DEFAULT(new DefaultScoreStrategy());

    ScoreStrategy scoreStrategy;

    ScoreCalculator(ScoreStrategy scoreStrategy) {
        this.scoreStrategy = scoreStrategy;
    }

    public static ScoreCalculator findByCards(List<Card> cards) {
        return Arrays.stream(values())
            .filter(scoreCalculator -> scoreCalculator.isSupportable(cards))
            .findFirst()
            .orElse(DEFAULT);
    }

    public int calculateScore(List<Card> cards) {
        return this.scoreStrategy.calculateScore(cards);
    }

    private boolean isSupportable(List<Card> cards) {
        return this.scoreStrategy.isSupportable(cards);
    }
}
