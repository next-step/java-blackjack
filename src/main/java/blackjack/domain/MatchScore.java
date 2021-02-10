package blackjack.domain;

import java.util.Arrays;

public enum MatchScore {
    WIN(1, "승"),
    DRAW(0, "무"),
    LOSE(-1, "패");

    private final int value;
    private final String name;

    MatchScore(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    private static MatchScore of(final int value) {
        return Arrays.stream(
            MatchScore.values()
        ).filter(
            result -> result.value == value
        ).findFirst().orElseThrow(
            () -> new RuntimeException("Unreachable point")
        );
    }

    public static MatchScore calcMatchScore(CardBunch player, CardBunch dealer) {
        // TODO : Check using Enum is useful? It may downgrade readability
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

    public MatchScore oppositeMatchScore() {
        return MatchScore.of(-value);
    }
}
