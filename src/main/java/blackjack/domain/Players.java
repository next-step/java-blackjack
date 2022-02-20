package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private int targetIndex;

    private Players(List<Player> players) {
        this.players = new ArrayList<>(players);
        this.targetIndex = 0;
    }

    public static Players from(final List<String> names) {
        return new Players(names.stream()
            .map(Player::new)
            .collect(Collectors.toList()));
    }

    public void drawCardMultiple(Deck deck, int number) {
        for (Player player : players) {
            player.drawCardMultiple(deck, number);
        }
    }

    public boolean isTargetAvailable(){
        return targetIndex <= players.size() - 1;
    }

    public void nextTargetIndex(){
        if(!isTargetAvailable())
            return;
        targetIndex ++;
    }

    public Player getTarget() {
        return players.get(targetIndex);
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
