package blackjack.domain;

public enum MatchScore {
    BLACKJACK_WIN(1.5),
    WIN(1.0),
    DRAW(0.0),
    LOSE(-1.0);

    private static final String UNREACHABLE_POINT_ERR_MSG = "예기치 않은 오류입니다.";

    private final double dividend;

    MatchScore(double key) {
        this.dividend = key;
    }

    public double getDividend() {
        return dividend;
    }

    public static Double calcDividend(CardBunch player, CardBunch dealer) {
        return calcMatchScore(player, dealer).getDividend();
    }

    private static MatchScore calcMatchScore(CardBunch player, CardBunch dealer) {
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
}
