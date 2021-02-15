package blackjack.domain;

import java.util.Arrays;

public enum MatchScore {
    BLACKJACK_WIN(1.5),
    WIN(1.0),
    DRAW(0.0),
    LOSE(-1.0);

    private static final String WRONG_MATCH_SCORE_KEY_ERR_MSG = "잘못된 매치 결과 키값입니다.";
    private static final String UNREACHABLE_POINT_ERR_MSG = "예기치 않은 오류입니다.";

    private final double dividend;

    MatchScore(double key) {
        this.dividend = key;
    }

    public double getDividend() {
        return dividend;
    }

    private static MatchScore of(final double value) {
        return Arrays.stream(
            MatchScore.values()
        ).filter(
            result -> result.dividend == value
        ).findFirst().orElseThrow(
            () -> new RuntimeException(WRONG_MATCH_SCORE_KEY_ERR_MSG)
        );
    }

    public static MatchScore calcMatchScore(CardBunch player, CardBunch dealer) {
        // TODO : Check using Enum is useful? It may downgrade readability
        if (player.isBust()) return LOSE;
        if (dealer.isBust()) return WIN;

        if (player.isBlackJack() && dealer.isBlackJack()) return DRAW;
        if (player.isBlackJack()) return BLACKJACK_WIN;
        if (dealer.isBlackJack()) return LOSE;

        if (player.calcScore() == dealer.calcScore()) return DRAW;
        if (player.calcScore() > dealer.calcScore()) return WIN;
        if (player.calcScore() < dealer.calcScore()) return LOSE;

        throw new RuntimeException(UNREACHABLE_POINT_ERR_MSG);
    }

    public MatchScore oppositeMatchScore() {
        if (dividend == 1.5) {
            return MatchScore.LOSE;
        }
        return MatchScore.of(-dividend);
    }
}
