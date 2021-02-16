package blackjack.domain.awards;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import java.util.List;

public class AwardsResult {

    private Dealer dealer;
    private List<Player> players;

    public AwardsResult(final Dealer dealer, final List<Player> players) {
        this.dealer = dealer;
        this.players = players;
    }

    public Dealer getDealerGameResult() {
        return dealer;
    }

    public List<Player> getPlayersGameResult() {
        return players;
    }
}
