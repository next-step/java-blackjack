package BlackJack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerResult {
    private List<Player> players;
    private Dealer dealer;
    private Map<String, String> playerResult = new HashMap<>();
    private int winCount;
    private int loseCount;

    public WinnerResult(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public Map<String, String> findWinnerPlayer() {
        for(Player player : players) {
            if(player.isDrawCard(player.sumCards())) {
                if(dealer.sumCards() < player.sumCards()) {
                    playerResult.put(player.getPlayerName(), "승");
                } else {
                    if(dealer.sumCards() > 21) {
                        playerResult.put(player.getPlayerName(), "승");
                    } else {
                        playerResult.put(player.getPlayerName(), "패");
                    }
                }
            } else {
                playerResult.put(player.getPlayerName(), "패");
            }
        }
        return playerResult;
    }

    public void countWinLoseDealer() {
        winCount = 0;
        loseCount = 0;
        for(Player player : players) {
            if(dealer.sumCards() <= 21) {
                if(dealer.sumCards() > player.sumCards()) {
                    winCount++;
                } else {
                    if(player.isDrawCard(player.sumCards())) {
                        winCount++;
                    } else {
                        loseCount++;
                    }
                }
            } else {
                loseCount++;
            }
        }
    }

    public Map<String, String> getPlayerResult() {
        return playerResult;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }
}
