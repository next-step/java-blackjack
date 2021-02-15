package blackjack.domain;

public class Card {

    private Suit suit;
    private Denomination denomination;

    public Card(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
            .append(getDenomination().getScore())
            .append(getSuit().getKoreanName()).toString();
    }
}
