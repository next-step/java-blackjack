package blackjack.domain.game;

import blackjack.domain.person.Player;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private final Map<String, String> playerResult;
    private int dealerWin;

    public GameResult(int dealerSum, List<Player> players) {
        this.playerResult = new HashMap<>();
        this.dealerWin = 0;
        initResult(dealerSum, players);
    }

    private void initResult(int dealerSum, List<Player> players) {
        for (Player player : players) {
            if (player.getPlayerCards().getSumOfCards() < dealerSum) {
                dealerWin++;
                playerResult.put(player.getName(), "패");
                continue;
            }
            playerResult.put(player.getName(), "승");
        }
    }

    public Map<String, String> getPlayerResult() {
        return playerResult;
    }

    public int getDealerWin() {
        return dealerWin;
    }
}
