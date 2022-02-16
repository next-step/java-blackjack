package blackjack.game;

import blackjack.domain.person.Dealer;
import blackjack.domain.person.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameSetup {

    private final Dealer dealer;
    private final List<Player> players;

    public GameSetup(List<String> playerNames) {
        dealer = new Dealer();
        players = createPlayers(playerNames);
    }

    private List<Player> createPlayers(List<String> playerNames) {
        return playerNames.stream()
            .map(name -> new Player(name, dealer.getPickedCard(2)))
            .collect(Collectors.toList());
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players);
    }
}
