package blackjack.domain.Card;

import java.util.ArrayList;
import java.util.List;

public class Players {

    private List<Player> players = new ArrayList<>();
    private String[] playernames;
    public Players(String[] playernames) {
        this.playernames = playernames;
        init();
    }

    private void init() {
        for(String playerName : playernames) {
            players.add(new Player(playerName));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
