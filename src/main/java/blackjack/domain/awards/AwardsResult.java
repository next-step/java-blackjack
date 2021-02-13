package blackjack.domain.awards;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import java.util.List;

public class AwardsResult {

    private Dealer dealer;
    private List<Player> players;

    public AwardsResult(Dealer dealer, List<Player> players) {
        this.dealer = dealer;
        this.players = players;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
