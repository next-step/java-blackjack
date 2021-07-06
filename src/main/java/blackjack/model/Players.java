package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Players {
    List<Player> players;

    public Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public void initialCardSetting() {
        for (Player player : players) {
            player.initialCardSetting();
        }
    }

    public int findMaxScore() {
        int maxScore = 0;
        for (Player player : players) {
            if (player.score() <= 21) {
                maxScore = Math.max(maxScore, player.score());
            }
        }
        return maxScore;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
