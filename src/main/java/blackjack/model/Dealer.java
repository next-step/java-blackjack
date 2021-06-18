package blackjack.model;

import blackjack.model.state.State;

public class Dealer extends Player {
    private static final int FIRST_CARD_INDEX = 0;
    private static final String DEALER_NAME = "딜러";

    public Dealer(State state) {
        super(state);
    }

    public String getFirstCard() {
        return getCardNames().get(FIRST_CARD_INDEX);
    }

    public String getName() {
        return DEALER_NAME;
    }
}
