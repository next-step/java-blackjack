package blackjack.model;

public class Card {
    private Denomination denomination;
    private Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public String getDenominationName() {
        return denomination.name();
    }

    public String getSuitName() {
        return suit.name();
    }

    public String getDenominationValue() {
        return Integer.toString(denomination.getValue());
    }

    public String getSuitValue() {
        return suit.getValue();
    }
}
