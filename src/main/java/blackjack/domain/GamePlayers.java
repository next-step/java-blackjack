package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlayers {

    private final List<GamePlayer> players;

    public GamePlayers(List<GamePlayer> players) {
        this.players = players;
    }

    public static GamePlayers makePlayers(List<String> playerNames) {

        List<GamePlayer> players = playerNames.stream()
            .map(player -> new Player(player))
            .collect(Collectors.toList());

        players.add(0, new Player("딜러"));

        return new GamePlayers(new ArrayList<>(players));
    }

    public GamePlayer getDealer() {
        return players.get(0);
    }

    public List<GamePlayer> getPlayers() {
        return Collections.unmodifiableList(players.subList(1, players.size()));
    }

    public List<GamePlayer> getAllPlayers() {
        return Collections.unmodifiableList(players);
    }
}
