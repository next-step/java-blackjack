package BlackJack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerResult {
    private List<Player> players;
    private Dealer dealer;

    public WinnerResult(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
        for (Player player : players) {
            dealer.winOrLose(player.compare(dealer.sumCards(), dealer.bust()),player.bust());
        }
    }

}
