package blackjack.model;

import java.util.EmptyStackException;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cards = new Stack<>();

    public Deck(final ShuffleStrategy shuffleStrategy) {
        collectCards();
        shuffleStrategy.shuffle(cards);
    }

    public Card getCard() {
        validateSize(cards);
        return cards.pop();
    }

    private void validateSize(Stack<Card> cards) {
        if (cards.size() == 0) {
            throw new EmptyStackException();
        }
    }

    private void collectCards() {
        for (int value = CardValue.MIN_VALUE; value < CardValue.MAX_VALUE + 1; value++) {
            cards.add(new Card(CardType.DIAMOND, CardValue.of(value)));
            cards.add(new Card(CardType.HEART, CardValue.of(value)));
            cards.add(new Card(CardType.SPADE, CardValue.of(value)));
            cards.add(new Card(CardType.CLOVER, CardValue.of(value)));
        }
    }
}