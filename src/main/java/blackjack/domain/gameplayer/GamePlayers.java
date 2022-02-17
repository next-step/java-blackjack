package blackjack.domain.gameplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlayers {

    private final List<GamePlayer> players;

    public GamePlayers(final Names players) {
        this.players = makePlayers(players);
    }

    public List<GamePlayer> makePlayers(final Names names) {
        final List<GamePlayer> players = names.getNames().stream()
            .map(Player::new)
            .collect(Collectors.toList());

        players.add(0, new DealerPlayer(new Name("딜러")));

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
