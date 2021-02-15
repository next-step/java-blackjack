package blackjack.model;

import java.util.Stack;

public class EmptyShuffleStrategy implements ShuffleStrategy {
    @Override
    public void shuffle(final Stack<Card> cards) {
        return;
    }
}
