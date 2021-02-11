package blackjack.domain;

import java.util.Arrays;

public enum Denomination {
    ACE(1, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K");

    private static final String WRONG_DENOMINATION_SCORE_ERR_MSG = "잘못된 카드 점수입니다.";

    private final int score;
    private final String name;

    public static Denomination of(final int score) {
        return Arrays
            .stream(Denomination.values())
            .filter(d -> d.score == score)
            .findFirst().orElseThrow(() -> new RuntimeException(WRONG_DENOMINATION_SCORE_ERR_MSG));
    }

    Denomination(final int score, final String name) {
        this.score = score;
        this.name = name;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getScore() {
        return score;
    }

    public String getName() { return name; }
}