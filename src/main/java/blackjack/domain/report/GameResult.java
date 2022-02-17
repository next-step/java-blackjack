package blackjack.domain.report;

import blackjack.domain.card.CardBundle;
import java.util.Arrays;

public enum GameResult {

    WIN(1, "승"),
    DRAW(0, "무"),
    LOSE(-1, "패");

    private final int result;
    private final String message;

    GameResult(int result, String message) {
        this.result = result;
        this.message = message;
    }

    public static GameResult comparing(CardBundle playerCardBundle, CardBundle dealerCardBundle) {
        isComparable(playerCardBundle, dealerCardBundle);
        if (playerCardBundle.isBurst()) {
            return GameResult.LOSE;
        }
        if (dealerCardBundle.isBurst()) {
            return GameResult.WIN;
        }
        int result = Integer.compare(playerCardBundle.calculateScore(),
            dealerCardBundle.calculateScore());
        return findResult(result);
    }

    public String message() {
        return message;
    }

    private static void isComparable(CardBundle dealerCardBundle, CardBundle playerCardBundle) {
        if (dealerCardBundle == null) {
            throw new IllegalArgumentException("[ERROR] 딜러의 카드가 비었습니다");
        }
        if (playerCardBundle == null) {
            throw new IllegalArgumentException("[ERROR] 플레이어의 카드가 비었습니다.");
        }
    }

    private static GameResult findResult(int result) {
        return Arrays.stream(values())
            .filter(gameResult -> gameResult.result == result)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바르지 않은 값 입니다"));
    }
}
