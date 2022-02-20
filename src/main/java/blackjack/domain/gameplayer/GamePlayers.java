package blackjack.domain.gameplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GamePlayers {

    private static final String DEALER = "딜러";
    private static final int FRONT = 0;

    private final List<GamePlayer> players;

    public GamePlayers(final List<GamePlayer> players) {
        this.players = players;
    }

    public static GamePlayers makePlayers(final Names names) {
        final List<GamePlayer> players = names.getNames().stream()
            .map(Player::new)
            .collect(Collectors.toList());

        players.add(FRONT, new DealerPlayer());

        return new GamePlayers(new ArrayList<>(players));
    }

    public GamePlayer getDealer() {
        return players.stream()
            .filter(player -> player.getName().equals(DEALER))
            .findAny()
            .orElseThrow(NullPointerException::new);
    }

    public List<GamePlayer> getPlayers() {
        return players.stream()
            .filter(player -> player != getDealer())
            .collect(Collectors.toList());
    }

    public List<GamePlayer> getAllPlayers() {
        return Collections.unmodifiableList(players);
    }
}
