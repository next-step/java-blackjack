package blackjack.domain;

public enum Suit {
    CLOVERS("클로버"),
    DIAMONDS("다이아몬드"),
    HEARTS("하트"),
    SPADES("스페이드");

    private final String nameString;

    Suit(final String nameString) {
        this.nameString = nameString;
    }

    public String getName() {
        return nameString;
    }
}
