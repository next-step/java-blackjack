package blackjack.domain;

import java.util.Arrays;

public enum MatchScore {
    WIN(1),
    DRAW(0),
    LOSE(-1);

    private final int value;

    MatchScore(final int value) {
        this.value = value;
    }

    private static MatchScore of(final int value) {
        return Arrays.stream(
            MatchScore.values()
        ).filter(
            result -> result.value == value
        ).findFirst().orElseThrow(
            () -> new RuntimeException("")
        );
    }

    public static MatchScore calcMatchScore(CardBunch player, CardBunch dealer) {
        // TODO : How to express checking order explicitly?
        if (player.isBust() && dealer.isBust()) throw new RuntimeException("Unreachable point");
        if (player.isBust()) return LOSE;
        if (dealer.isBust()) return WIN;

        if (player.isBlackJack() && dealer.isBlackJack()) return DRAW;
        if (player.isBlackJack()) return WIN;
        if (dealer.isBlackJack()) return LOSE;

        if (player.calcScore() == dealer.calcScore()) return DRAW;
        if (player.calcScore() > dealer.calcScore()) return WIN;
        if (player.calcScore() < dealer.calcScore()) return LOSE;

        throw new RuntimeException("Unreachable point");
    }

    public MatchScore oppositeResult(MatchScore matchScore) {
        return MatchScore.of(1 - matchScore.value);
    }

    public int getValue() {
        return value;
    }
}
