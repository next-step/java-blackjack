package blackjack.model;

import java.util.Stack;

public interface ShuffleStrategy {
    void shuffle(final Stack<Card> cards);
}