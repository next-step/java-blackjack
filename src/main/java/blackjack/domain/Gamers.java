package blackjack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Gamers {

    private List<Gamer> gamers;
    private static final String COMMA = ",";
    private static final String NAME_PATTERN = "^[a-zA-Z가-힣]*$";

    public Gamers(String gamer, Deck deck) throws IllegalArgumentException {
        String[] gamerNames = gamer.split(COMMA);
        validateGamerNames(gamerNames);
        makeGamers(gamerNames, deck);
    }

    public Gamers(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    private void makeGamers(String[] names, Deck deck) {
        gamers = Arrays.stream(names)
            .map(
                name -> new Gamer(name, deck)
            ).collect(
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
            .filter(
                name -> name.matches(NAME_PATTERN)
            ).count() == gamerNames.length;
    }

    public List<Gamer> getGamers() {
        return gamers;
    }

    public List<String> getGamerInfo() {
        return Arrays.asList(toString().split("\n"));
    }

    @Override
    public String toString() {
        return gamers.stream()
            .map(
                Gamer::toString
            ).collect(
                Collectors.joining("\n")
            );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Gamers gamers1 = (Gamers) o;
        return Objects.equals(gamers, gamers1.gamers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gamers);
    }
}
