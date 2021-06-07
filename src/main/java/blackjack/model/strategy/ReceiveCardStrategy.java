package blackjack.model.strategy;

@FunctionalInterface
public interface ReceiveCardStrategy {
    int getReceiveCardCondition();
}
