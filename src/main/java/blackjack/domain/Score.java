package blackjack.domain;

public enum Score {
    WIN(1, "승"),
    DRAW(0, "무"),
    LOSE(-1, "패");

    private static final String UNDETECTABLE_EXCEPTION_OCCURRED = "예기치 않은 오류가 발생했습니다.";

    private final int key;
    private final String name;

    Score(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public static Score judge(Cards playerCards, Cards dealerCards) {
        if (playerCards.isBust()) return LOSE;

        if (playerCards.blackjack() && dealerCards.blackjack()) return DRAW;
        if (playerCards.blackjack()) return WIN;
        if (dealerCards.blackjack()) return LOSE;

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
}
