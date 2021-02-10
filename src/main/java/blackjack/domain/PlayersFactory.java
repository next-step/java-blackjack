package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayersFactory {
    private static final String COMMA = ",";

    public static List<Person> generatePlayers(String names) {
        return Arrays.stream(
            names.split(COMMA)
        ).map(
            Person::createPlayer
        ).collect(
            Collectors.toList()
        );
    }
}
