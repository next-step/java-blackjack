package blackjack.domain.score;

import blackjack.domain.card.Card;
import java.util.List;

public enum ScoreCalculator {

    ACE,
    DEFAULT;


    ScoreCalculator() {
    }

    public static ScoreCalculator findByCards(List<Card> cards) {
        return null;
    }

    public int calculateScore(List<Card> cards) {
        return 0;
    }
}
