package blackjack.domain;

import blackjack.dto.PersonCardsInfo;

public class Dealer extends Person {
    private static final String DEALER_NAME = "딜러";
    public static final Integer DEALER_DRAW_LIMIT = 16;

    public Dealer() {
        super(DEALER_NAME);
    }

    public Dealer(CardBunch cardBunch) {
        super(DEALER_NAME, cardBunch);
    }

    @Override
    public boolean canDrawCard() {
        return cardBunch.calcScore() <= DEALER_DRAW_LIMIT && !cardBunch.isBust();
    }

    public PersonCardsInfo getPersonCardsInfoFirstCardOnly() {
        return new PersonCardsInfo(name, cardBunch.getFirstCardName());
    }
}
