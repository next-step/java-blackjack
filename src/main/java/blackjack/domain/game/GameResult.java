package blackjack.domain.game;

import java.util.Map;

public class GameResult {

    private final Map<String, String> playerResult;
    private final int dealerWin;
    private final int dealerLose;

    public GameResult(Map<String, String> playerResult, int dealerWin, int dealerLose) {
        this.playerResult = playerResult;
        this.dealerWin = dealerWin;
        this.dealerLose = dealerLose;
    }

    public Map<String, String> getPlayerResult() {
        return playerResult;
    }

    public int getDealerWin() {
        return dealerWin;
    }

    public int getDealerLose() {
        return dealerLose;
    }
}
