package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlayers {

    private final List<GamePlayer> players;

    public GamePlayers(final List<String> players) {
        this.players = makePlayers(players);
    }

    public List<GamePlayer> makePlayers(List<String> playerNames) {
        final List<GamePlayer> players = playerNames.stream()
            .map(Player::new)
            .collect(Collectors.toList());

        players.add(0, new DealerPlayer("딜러"));

        return new ArrayList<>(players);
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
