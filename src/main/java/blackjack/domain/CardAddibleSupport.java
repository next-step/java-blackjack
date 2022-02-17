package blackjack.domain;

public abstract class CardAddibleSupport implements CardAddible {
    Cards cards;

    public CardAddibleSupport(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }
}
