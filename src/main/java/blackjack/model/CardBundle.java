package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardBundle {

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
        for (Number number : Number.values()) {
            cards.add(Card.of(type, number));
        }
        concat(cards);
    }

    private void concat(List<Card> cards){
        this.cards.addAll(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

}
