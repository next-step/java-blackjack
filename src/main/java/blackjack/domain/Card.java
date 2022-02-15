package blackjack.domain;

public class Card {

    private final String symbol;
    private final String name;
    private final int point;
    private int lowerAcePoint;

    public Card(String symbol, String name, int point) {
        this.symbol = symbol;
        this.name = name;
        this.point = point;
    }

    public Card(String symbol, String name, int point, int lowerAcePoint) {
        this.symbol = symbol;
        this.name = name;
        this.point = point;
        this.lowerAcePoint = lowerAcePoint;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return this.point;
    }

    public int getLowerAcePoint() {
        return this.lowerAcePoint;
    }
}
