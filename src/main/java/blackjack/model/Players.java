package blackjack.model;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(String inputNames) {
        final Deck deck = new Deck(new RandomShuffleStrategy());
        players = Arrays
                .stream(inputNames.split(","))
                .map(String::trim)
                .map(cleanName -> new Gamer(cleanName, deck))
                .collect(Collectors.toList());
        players.add(0, new Dealer(deck));
    }

    public Players(String inputNames, ShuffleStrategy shuffleStrategy) {
        final Deck deck = new Deck(shuffleStrategy);
        players = Arrays
                .stream(inputNames.split(","))
                .map(String::trim)
                .map(cleanName -> new Gamer(cleanName, deck))
                .collect(Collectors.toList());
        players.add(0, new Dealer(deck));
    }

    public List<Player> getPlayers(final Predicate<Player> playerPredicate) {
        return players.stream().filter(playerPredicate).collect(Collectors.toList());
    }

    public String getPlayerNames(final Predicate<Player> playerPredicate) {
        return players
                .stream()
                .filter(playerPredicate)
                .map(Player::getName)
                .collect(Collectors.joining(", "));
    }
}