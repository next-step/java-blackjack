package blackjack.domain.card;

public class Score {

    private static final int INIT_VALUE = 0;

    private final int value;

    public Score() {
        this(INIT_VALUE);
    }

    public Score(final int value) {
        this.value = value;
    }

    public Score sum(final int value) {
        return new Score(this.value + value);
    }

    public int getValue() {
        return value;
    }

    public boolean isUnder(final int value) {
        return this.value < value;
    }
}
