package blackjack.domain;

public class Card {

    private final String symbol;
    private final String name;
    private final int point;

    public Card(String symbol, String name, int point) {
        this.symbol = symbol;
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return this.point;
    }
}
