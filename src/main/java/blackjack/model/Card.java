package blackjack.model;

import java.util.Objects;

import static blackjack.utils.StringUtils.SPACE;

public class Card {
    private final Type type;
    private final Symbol symbol;


    private Card(Type type, Symbol symbol) {
        this.type = type;
        this.symbol = symbol;
    }

    public Type getType() {
        return type;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public static Card of(Type type, Symbol symbol) {
        return new Card(type, symbol);
    }

    @Override
    public String toString() {
        return symbol.getName() + type.getName() + SPACE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return type == card.type && symbol == card.symbol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, symbol);
    }
}
