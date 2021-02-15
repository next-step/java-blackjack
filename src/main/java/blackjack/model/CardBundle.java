package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class CardBundle {

    private static final int BLACK_JACK = 21;
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

    public void generateOneTypeCards(Type type){
        List<Card> cards = new ArrayList<>();
        for (Symbol symbol : Symbol.values()) {
            cards.add(Card.of(type, symbol));
        }
        concat(cards);
    }

    private void concat(List<Card> cards){
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

        int expectedSum = sum + ACE_BONUS;
        sum += cards.stream()
                .filter(card -> canChangeAceScore(card, expectedSum))
                .mapToInt(card -> ACE_BONUS)
                .sum();

        return sum;
    }

    private boolean canChangeAceScore(Card card, int expectedSum){
        return card.getSymbol() == Symbol.ACE && expectedSum <= BLACK_JACK;
    }
}
