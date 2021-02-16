package blackjack.domain;

import blackjack.dto.PersonCardsInfo;
import blackjack.dto.PersonMatchProfitInfo;

public class Dealer extends Person {
    private static final String DEALER_NAME = "딜러";
    public static final Integer DEALER_DRAW_LIMIT = 16;

    private int profit;

    public Dealer() {
        super(DEALER_NAME);
        this.profit = 0;
    }

    public Dealer(CardBunch cardBunch) {
        super(DEALER_NAME, cardBunch);
        this.profit = 0;
    }

    public Dealer(int profit) {
        super(DEALER_NAME);
        this.profit = profit;
    }

    public Dealer(int profit, CardBunch cardBunch) {
        super(DEALER_NAME, cardBunch);
        this.profit = profit;
    }

    @Override
    public boolean canDrawCard() {
        return cardBunch.calcScore() <= DEALER_DRAW_LIMIT && !cardBunch.isBust();
    }

    public void addProfit(int profit) {
        this.profit += profit;
    }

    public PersonMatchProfitInfo getDealerProfitInfo() {
        return new PersonMatchProfitInfo(name, profit);
    }

    public PersonCardsInfo getPersonCardsInfoFirstCardOnly() {
        return new PersonCardsInfo(name, cardBunch.getFirstCardName());
    }
}
