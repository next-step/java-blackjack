package blackjack.model;

import java.util.Objects;

public class Card {
    private final CardType cardType;
    private final CardValue cardValue;

    public Card(final CardType type, final CardValue value) {
        this.cardType = type;
        this.cardValue = value;
    }

    public String getName() {
        return parseCard(cardType, cardValue);
    }

    public int getScore() {
        return cardValue.getScore();
    }

    public CardValue getValue() {
        return cardValue;
    }

    private String parseCard(final CardType cardType, final CardValue cardValue) {
        return cardValue.getTag() + cardType.getType();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardType == card.cardType && cardValue == card.cardValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardValue);
    }
}