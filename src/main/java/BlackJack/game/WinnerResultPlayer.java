package BlackJack.game;

import BlackJack.actor.Dealer;
import BlackJack.actor.Player;

public class WinnerResultPlayer {
    private int winCount = 0;
    private int loseCount = 0;

    public boolean playerResult(Player player, Dealer dealer) {
            return dealer.countWinLose(player);
    }

    public void resultCount(Player player, Dealer dealer) {
        if (dealer.countWinLose(player)) {
            this.winCount++;
            return;
        }
        this.loseCount++;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getLoseCount() {
        return loseCount;
    }
}
