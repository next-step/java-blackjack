package blackjack.domain.card;

public enum Pattern {

    SPADE("스페이드"),
    CLUB("클로버"),
    HEART("하트"),
    DIAMOND("다이아몬드");

    private final String name;

    Pattern(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
