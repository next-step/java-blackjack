package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerFactory {
    private static final String COMMA = ",";

    public static List<Player> generatePlayers(String names) {
        return Arrays.stream(
            names.split(COMMA)
        ).map(
            Player::new
        ).collect(
            Collectors.toList()
        );
    }
}
