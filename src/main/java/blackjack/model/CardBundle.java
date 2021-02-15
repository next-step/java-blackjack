package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class CardBundle {

    private static final int BLACK_JACK = 21;
    private static final int ACE = 10;
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
        // ACE 의 계산 방식 고려해야함
        int sum = 0;
        for (Card card : cards) {
            sum += card.getSymbol().getScore();
        }
        for (Card card : cards) {
            sum = getSum(sum, card);
        }
        return sum;
    }

    private int getSum(int sum, Card card) {
        if (card.getSymbol() == Symbol.ACE || sum + ACE < BLACK_JACK) {
            sum += ACE;
        }
        return sum;
    }


}
