package blackjack.domain;

public class Card {

    private final Shape shape;
    private final Denomination denomination;

    public Card(Shape shape, Denomination denomination) {
        this.shape = shape;
        this.denomination = denomination;
    }

    public Denomination getDenomination() {
        return denomination;
    }
}
