package blackjack.domain;

import java.util.List;

public abstract class CardAddibleSupport implements CardAddible {
    List<Card> cards;

    public CardAddibleSupport(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public List<Card> cards() {
        return cards;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public int getTotalScore() {

        return cards.stream().mapToInt(card -> card.getCardNumber().getScore()).sum();
    }
}
