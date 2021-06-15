package BlackJack.game;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private Map<String, Integer> winResult = new HashMap<>();
    private Map<String, Integer> loseResult = new HashMap<>();

    public void injectResult(String playerName, int winCount, int loseCount) {
        winResult.put(playerName, winCount);
        loseResult.put(playerName, loseCount);
    }

    public Map<String, Integer> getWinResult() {
        return winResult;
    }

    public Map<String, Integer> getLoseResult() {
        return loseResult;
    }
}
