package blackjack.domain;

import java.util.Arrays;

public enum Score {
    WIN(1, "승"),
    DRAW(0, "무"),
    LOSE(-1, "패");

    private static final String UNDETECTABLE_EXCEPTION_OCCURRED = "예기치 않은 오류가 발생했습니다.";

    private final int key;
    private final String name;

    Score(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    public static Score of(final int key) {
        return Arrays.stream(values())
            .filter(score -> score.key == key)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("존재하지 않는 키입니다."));
    }

    public static Score judge(final Cards playerCards, final Cards dealerCards) {
        if (playerCards.isBust()) {
            return LOSE;
        }

        if (playerCards.blackjack() && dealerCards.blackjack()) {
            return DRAW;
        }
        if (playerCards.blackjack()) {
            return WIN;
        }
        if (dealerCards.blackjack()) {
            return LOSE;
        }

        if (playerCards.totalScore() == dealerCards.totalScore()) {
            return DRAW;
        }

        if (playerCards.totalScore() > dealerCards.totalScore()) {
            return WIN;
        }

        if (playerCards.totalScore() < dealerCards.totalScore()) {
            return LOSE;
        }

        throw new RuntimeException(UNDETECTABLE_EXCEPTION_OCCURRED);
    }

    public Score oppositeScore() {
        return Score.of(-key);
    }

    public String getName() {
        return name;
    }
}
