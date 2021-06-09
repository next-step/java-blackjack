package blackjack.service;

public enum CardPattern {
    CLUBS("클로버"),
    DIAMONDS("다이아몬드"),
    HEARTS("하트"),
    SPADES("스페이스");

    private String mark;

    CardPattern(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
