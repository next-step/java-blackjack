package blackjack.domain.Card;

public class Card {
    private final Denomination denomination;
    private final Suit suit;

    public Card(final Denomination denomination, final Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }

}
