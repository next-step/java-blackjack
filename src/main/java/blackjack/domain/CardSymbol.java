package blackjack.domain;

public enum CardSymbol {
    SPADE("스페이드"),
    DIAMOND("다이아몬드"),
    CLOVER("클로버"),
    HEART("하트");

    private final String symbol;

    CardSymbol(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
