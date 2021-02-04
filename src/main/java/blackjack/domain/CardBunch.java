package blackjack.domain;

import java.util.List;

public class CardBunch {
    private final List<Card> cardBunch;

    public CardBunch(List<Card> cardBunch) {
        this.cardBunch = cardBunch;
    }

    public Integer calcScore() {
        int score = 0;
        Boolean haveAce = false;

        // TODO : make it more clear
        for(Card card : cardBunch) {
            score += card.getScore();
            if (card.isAce())  {
                haveAce = true;
            }
        }

        if (haveAce && score < 12) {
            return score + 10;
        }
        return score;
    }
}
