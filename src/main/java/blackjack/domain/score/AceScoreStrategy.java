package blackjack.domain.score;

import blackjack.domain.card.Card;
import java.util.List;

public class AceScoreStrategy implements ScoreStrategy {

    private static final int BLACK_JACK_SCORE = 21;
    private static final int ACE_WEIGHT_SCORE = 10;

    private int getAceCount(List<Card> cards) {
        return (int) cards.stream()
            .filter(Card::isAce)
            .count();
    }

    private int convertScore(Card card) {
        if (card.isAce()) {
            return card.value() + ACE_WEIGHT_SCORE;
        }
        return card.value();
    }

    @Override
    public boolean isSupportable(List<Card> cards) {
        return getAceCount(cards) > 0;
    }

    @Override
    public int calculateScore(List<Card> cards) {
        int score = cards.stream()
            .mapToInt(this::convertScore)
            .sum();
        int aceCount = getAceCount(cards);
        while (score > BLACK_JACK_SCORE && aceCount > 0) {
            score -= ACE_WEIGHT_SCORE;
            aceCount--;
        }
        return score;
    }
}
