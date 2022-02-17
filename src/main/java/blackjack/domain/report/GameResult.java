package blackjack.domain.report;

import blackjack.domain.card.CardBundle;

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
        return null;
    }
}
