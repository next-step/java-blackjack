package blackjack.domain;

public enum CardType {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    ACE("11", 11),
    QUEEN("10", 10),
    KING("10", 10),
    JACK("10", 10);

    private final String name;
    private final int point;

    CardType(String name, int value) {
        this.name = name;
        this.point = value;
    }

    public String getName() {
        return this.name;
    }

    public int getPoint() {
        return this.point;
    }
}
