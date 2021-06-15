package blackjack;

public class Card {
    private Denomination denomination;
    private Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public String getDenomination() {
        return denomination.name();
    }

    public String getSuit() {
        return suit.name();
    }
}
