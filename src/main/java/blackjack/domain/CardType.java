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
    ACE("A", 11),
    QUEEN("Q", 10),
    KING("K", 10),
    JACK("J", 10);

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
