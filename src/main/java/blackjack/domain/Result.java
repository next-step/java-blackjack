package blackjack.domain;

import java.util.Arrays;

public enum Result {
    WIN(-1, true),
    DRAW(0, false),
    LOSE(1, false);

    private final int value;
    private final boolean isBlackJack;

    Result(final int value, final boolean isBlackJack) {
        this.value = value;
        this.isBlackJack = isBlackJack;
    }

    public static Result of(final int value) {
        return Arrays.stream(
            Result.values()
        ).filter(
            result -> result.value == value
        ).findFirst().orElseThrow(
            () -> new RuntimeException("")
        );
    }

    // TODO: BlackJack이 있을 때 compareTo 쓰는거... 별로인듯
    public static Result calcResult(CardBunch first, CardBunch second) {
        if (first.isBust()) {
            return LOSE;
        }

        if (second.isBust()) {
            return WIN;
        }

        return Result.of(
            second.calcScore().compareTo(
                first.calcScore()
            )
        );
    }
}
