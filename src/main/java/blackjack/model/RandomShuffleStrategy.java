package blackjack.model;

import java.util.Collections;
import java.util.Stack;

public class RandomShuffleStrategy implements ShuffleStrategy {
    @Override
    public void shuffle(final Stack<Card> cards) {
        Collections.shuffle(cards);
    }
}