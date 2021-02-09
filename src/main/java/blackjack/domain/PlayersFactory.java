package blackjack.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PlayersFactory {
    private static final String COMMA = ",";

    public static Players generatePlayers(String names) {
        return new Players(Arrays.stream(
            names.split(COMMA)
        ).map(
            name -> new Player(name, new PlayerCardBunch())
        ).collect(
            Collectors.toList()
        ));
    }
}
