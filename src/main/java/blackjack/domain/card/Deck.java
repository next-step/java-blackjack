package blackjack.domain.card;

public class Deck {

    private final Cards cards;

    public Deck(final Cards cards) {
        this.cards = cards;
    }

    public Deck() {
        this(Cards.create());
    }

    public Deck deduction(final Card card) {
        return new Deck(cards.without(card));
    }

    public Card draw() {
        return cards.drawOne();
    }
}
