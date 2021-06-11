package BlackJack;

import java.util.List;

public class WinnerResult {
    private final List<Player> players;
    private final Dealer dealer;

    public WinnerResult(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        for (Player player : this.players) {
            this.dealer.countWinLose(player);
        }
    }
}
