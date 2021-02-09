package blackjack.model;

import java.util.Objects;

public class Card {
    private final Type type;
    private final Number number;


    private Card(Type type, Number number) {
        this.type = type;
        this.number = number;
    }

    public Type getType() {
        return type;
    }

    public Number getNumber() {
        return number;
    }

    public static Card of(Type type, Number number) {
        return new Card(type, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type && number == card.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number);
    }
}
