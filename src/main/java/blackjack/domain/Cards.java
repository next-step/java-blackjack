package blackjack.domain;

import java.util.List;

public class Cards {

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int result = 0;
        for (Card card : cards) {
            result += card.getDenomination().getScore();
        }
        return result;
    }

    public List<Card> getCards() {
        return cards;
    }
}
