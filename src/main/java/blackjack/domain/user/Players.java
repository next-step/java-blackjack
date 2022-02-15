package blackjack.domain.user;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players(Dealer dealer, List<Player> players) {
        this.players.add(dealer);
        this.players.addAll(players);
    }

    public List<Player> findOnlyPlayers() {
        return null;
    }

    public Player findDealer() {
        return null;
    }

    public boolean hasBlackJack() {
        return false;
    }
}
