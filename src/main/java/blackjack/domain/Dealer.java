package blackjack.domain;

import blackjack.dto.CardInfo;

public class Dealer extends Person {

    private static final Integer REQUEST_LIMIT = 16;
    private static final String DEALER_NAME = "딜러";

    public Dealer() {
        super(DEALER_NAME);
    }

    public Dealer(CardBunch cardBunch) {
        super(DEALER_NAME, cardBunch);
    }

    public CardInfo getFirstCard() {
        return cardBunch.getCardBunchInfo().getCardsInfo().get(0);
    }

    @Override
    public boolean canDraw() {
        return !cardBunch.isBust() && cardBunch.calcScore() <= REQUEST_LIMIT;
    }

}
