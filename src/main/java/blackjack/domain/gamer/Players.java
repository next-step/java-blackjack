package blackjack.domain.gamer;

import blackjack.domain.matchInfo.MatchResultBoard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players = new ArrayList<>();
    private final String[] playerNames;

    public Players(String[] playerNames) {
        this.playerNames = playerNames;
        init();
    }

    private void init() {
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public MatchResultBoard playMatch(Gamer dealer) {
        return new MatchResultBoard(players.stream()
            .collect(
                Collectors.toMap(player -> player, player -> player.getMatchResult(player, dealer),
                    (player1, player2) -> player1, LinkedHashMap::new)));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
