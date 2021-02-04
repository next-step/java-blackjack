package blackjack.domain;

import java.util.List;

public class CardBunch {
    private final List<Card> cardBunch;

    public CardBunch(List<Card> cardBunch) {
        this.cardBunch = cardBunch;
    }

    public Integer calcScore() {
        int score = cardBunch.stream().mapToInt(
            Card::getScore
        ).sum();
        boolean haveAce = cardBunch.stream().anyMatch(
            Card::isAce
        );

        if (haveAce && score < 12) {
            return score + 10;
        }
        return score;
    }
}
