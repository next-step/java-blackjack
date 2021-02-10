package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersFactory {
    public static List<Player> generatePlayers(String[] names) {
        return Arrays
            .stream(names)
            .map(Player::new)
            .collect(Collectors.toList());
    }
}