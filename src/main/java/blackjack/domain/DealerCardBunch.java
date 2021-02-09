package blackjack.domain;

import blackjack.dto.CardBunchInfo;

import java.util.List;

public class DealerCardBunch extends CardBunch {
    private static final Integer REQUEST_LIMIT = 17;

    public DealerCardBunch() {
        super();
    }

    public DealerCardBunch(List<Card> cardBunch) {
        super(cardBunch);
    }

    public DealerCardBunch(List<Integer> score, Suit suit) {
        super(score, suit);
    }

    @Override
    public boolean canDrawCard() {
        return !isBust() && isNeedMoreDraw();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private boolean isNeedMoreDraw() {
        return calcScore() < REQUEST_LIMIT;
    }

    public CardBunchInfo getHiddenCardBunchInfo() {
        return new CardBunchInfo(
            List.of(
                cardBunch.get(0).getCardInfo()
            )
        );
    }
}
