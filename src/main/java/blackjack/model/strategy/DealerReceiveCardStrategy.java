package blackjack.model.strategy;

public class DealerReceiveCardStrategy implements ReceiveCardStrategy {
    private static final int RECEIVE_CARD_CONDITION = 17;

    @Override
    public int getReceiveCardCondition() {
        return RECEIVE_CARD_CONDITION;
    }
}
