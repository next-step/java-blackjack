package blackjack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public static Players createPlayers(List<String> input) {
        return new Players(input.stream().map(Player::new).collect(Collectors.toList()));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
