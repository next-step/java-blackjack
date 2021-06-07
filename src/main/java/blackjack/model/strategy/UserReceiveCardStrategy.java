package blackjack.model.strategy;

public class UserReceiveCardStrategy implements ReceiveCardStrategy {
    private static final int RECEIVE_CARD_CONDITION = 21;

    @Override
    public int getReceiveCardCondition() {
        return RECEIVE_CARD_CONDITION;
    }
}
