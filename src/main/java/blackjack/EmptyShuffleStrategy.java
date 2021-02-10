package blackjack;

import java.util.Stack;

public class EmptyShuffleStrategy implements ShuffleStrategy {
    @Override
    public void shuffle(Stack<Card> cards) {
        return;
    }
}
