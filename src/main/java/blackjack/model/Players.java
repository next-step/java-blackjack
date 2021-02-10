package blackjack.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private final ShuffleStrategy shuffleStrategy = new RandomShuffleStrategy();
    private final Deck deck = new Deck(shuffleStrategy);
    private final List<Player> players;

    public Players(String inputNames) {
        players = Arrays
                .stream(inputNames.split(","))
                .map(String::trim)
                .map(cleanName -> new Gamer(cleanName, deck))
                .collect(Collectors.toList());
        players.add(new Dealer(deck));
    }

    public List<Player> getPlayers() {
        return players;
    }
}