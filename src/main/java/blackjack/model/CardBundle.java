package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class CardBundle {
    public static final int BLACK_JACK = 21;
    private static final int ACE_BONUS = 10;
    private final List<Card> cards;

    private CardBundle(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public static CardBundle of(List<Card> cards) {
        return new CardBundle(cards);
    }

    public void generateOneTypeCards(Type type) {
        List<Card> cards = new ArrayList<>();
        for (Symbol symbol : Symbol.values()) {
            cards.add(Card.of(type, symbol));
        }
        concat(cards);
    }

    private void concat(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int calculateScore() {
        int sum = cards.stream()
                .reduce(0,
                        (subtotal, card) -> subtotal + card.getSymbol().getScore(),
                        Integer::sum
                );

        for (Card card : cards) {
            sum += checkAceScore(card, sum);
        }

        return sum;
    }

    private int checkAceScore(Card card, int expectedSum) {
        if (canChangeAceScore(card, expectedSum)) {
            return ACE_BONUS;
        }
        return 0;
    }

    private boolean canChangeAceScore(Card card, int expectedSum) {
        return card.getSymbol() == Symbol.ACE && expectedSum + ACE_BONUS <= BLACK_JACK;
    }
}
