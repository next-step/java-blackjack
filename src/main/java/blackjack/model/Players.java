package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players = new ArrayList<>();

    public Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }
}
