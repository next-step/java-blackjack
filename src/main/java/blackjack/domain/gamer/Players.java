package blackjack.domain.gamer;

import blackjack.domain.matchInfo.MatchResultBoard;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players = new ArrayList<>();
    private String[] playernames;

    public Players(String[] playernames) {
        this.playernames = playernames;
        init();
    }

    private void init() {
        for (String playerName : playernames) {
            players.add(new Player(playerName));
        }
    }

    public MatchResultBoard playMatch(Dealer dealer) {
        return new MatchResultBoard(players.stream().collect(Collectors.toMap(player -> player, player -> player.getMatchResult(player, dealer))));
    }

    public List<Player> getPlayers() {
        return players;
    }
}
