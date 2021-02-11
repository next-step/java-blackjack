package blackjack.model;

import java.util.Objects;

public class Card {
    private final CardType cardType;
    private final CardValue cardValue;
    private final String name;

    public Card(CardType type, CardValue value) {
        this.cardType = type;
        this.cardValue = value;
        this.name = parseCard(cardType, cardValue);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return cardValue.getScore();
    }

    public CardValue getValue() {
        return cardValue;
    }

    private String parseCard(CardType cardType, CardValue cardValue) {
        return cardValue.getTag() + cardType.getType();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardType == card.cardType && cardValue == card.cardValue && Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardType, cardValue, name);
    }
}