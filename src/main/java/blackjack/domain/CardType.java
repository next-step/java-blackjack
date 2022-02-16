package blackjack.domain;

public enum CardType {
    ACE("A", 11, 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String name;
    private final int point;
    private int lowerAcePoint;

    CardType(String name, int point) {
        this.name = name;
        this.point = point;
    }

    CardType(String name, int point, int lowerAcePoint) {
        this.name = name;
        this.point = point;
        this.lowerAcePoint = lowerAcePoint;
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

    public boolean isAce() {
        return this == CardType.ACE;
    }
}
