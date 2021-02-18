package blackjack.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PlayersFactory {

    private static final String COMMA = ",";

    private PlayersFactory() {

    }

    public static Players generatePlayers(String names) {
        return new Players(Arrays.stream(
                names.split(COMMA)
        ).map(
                Player::new
        ).collect(
                Collectors.toList()
        ));
    }
}
