package blackjack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Table {
    private List<Player> players;
    private Dealer dealer;

    public Table(List<Player> players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public Map<String, Boolean> result() {
        return players.stream()
                .collect(Collectors.toMap(
                 player -> player.getName(),
                        player -> dealer.isWin(player)
                ));
    }

}
