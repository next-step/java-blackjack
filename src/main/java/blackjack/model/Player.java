package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    protected final CardBundle cardHand;
    protected final String name;

    public Player(CardBundle cardHand, String name) {
        this.cardHand = cardHand;
        this.name = name;
    }

    public Player(String name) {
        this.cardHand = CardBundle.of(new ArrayList<>());
        this.name = name;
    }

    public CardBundle getCardHand() {
        return cardHand;
    }

    public String getName() {
        return name;
    }

    public void drawCard(Card card) {
        cardHand.add(card);
    }

    public int calculateScore() {
     // ACE 의 계산 방식 고려해야함
        List<Card> cards = cardHand.getCards();
        int sum = 0;
        for (Card card : cards) {
            sum += card.getSymbol().getScore();
        }

        return sum;
    }
}
