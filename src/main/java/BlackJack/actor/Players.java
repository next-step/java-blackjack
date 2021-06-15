package BlackJack.actor;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> players = new ArrayList<>();

    public Players(){}

    public Players(List<Player> players) {
        this.players = players;
    }
    public void add(Player player) {
        players.add(player);
    }
    public List<Player> getPlayers() {
        return players;
    }
}
