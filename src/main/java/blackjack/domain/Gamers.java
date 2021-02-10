package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gamers {

    private List<Gamer> gamers;
    private static final String COMMA = ",";
    private static final String NAME_PATTERN = "^[a-zA-Z]*$";

    public Gamers(String gamer) throws IllegalArgumentException {
        String[] gamerNames = gamer.split(COMMA);
        validateGamerNames(gamerNames);
        makeGamers(gamerNames);
    }

    private void makeGamers(String[] names) {
        gamers = Arrays.stream(names).map(Gamer::new)
            .collect(
                Collectors.toList()
            );
    }

    private void validateGamerNames(String[] gamerNames) throws IllegalArgumentException {
        if (!checkNameCount(gamerNames)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNameCount(String[] gamerNames) {
        return Arrays.stream(gamerNames)
            .filter(name -> name.matches(NAME_PATTERN))
            .count() == gamerNames.length;
    }
}
