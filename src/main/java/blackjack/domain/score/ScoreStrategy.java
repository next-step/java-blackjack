package blackjack.domain.score;

import blackjack.domain.card.Card;
import java.util.List;

public interface ScoreStrategy {

    boolean isSupportable(List<Card> cards);

    int calculateScore(List<Card> cards);
}
