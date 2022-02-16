package blackjack.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    public Players(List<String> playerNames) {
        this.players = playerNames.stream()
            .map(Player::from)
            .collect(Collectors.toList());
    }

    public void deal(CardDeck deck) {
        for (Player player : players) {
            player.deal(deck);
        }
    }

    public List<Player> get() {
        return players;
    }
    
}
