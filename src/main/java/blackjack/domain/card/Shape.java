package blackjack.domain.card;

public enum Shape {

    HEART("하트"),
    DIAMOND("다이아몬드"),
    SPADE("스페이드"),
    CLUB("클로버");

    private final String name;

    public String getName() {
        return name;
    }

    Shape(String name) {
        this.name = name;
    }
}
