package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GamePlayers {

    private final List<Player> players;

    public GamePlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public static GamePlayers makePlayers(List<String> playerNames) {
        List<Player> dealerPlayers = Arrays.asList(new Player("딜러", true));
        List<Player> commonPlayers = playerNames.stream()
            .map(player -> new Player(player, false))
            .collect(Collectors.toList());

        List<Player> players = Stream.of(dealerPlayers, commonPlayers)
            .flatMap(lotto -> lotto.stream())
            .collect(Collectors.toList());

        return new GamePlayers(players);
    }
}
