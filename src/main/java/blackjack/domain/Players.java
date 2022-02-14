package blackjack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Participant> players;

    private Players(List<Participant> players) {
        this.players = players;
    }

    public static Players from(final List<String> names) {
        return new Players(names.stream().map(Player::new).collect(Collectors.toList()));
    }

    public void drawCardAll(int number) {
        for (Participant player : players) {
            player.drawCard(number);
        }
    }
}
