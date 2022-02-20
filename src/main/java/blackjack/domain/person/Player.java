package blackjack.domain.person;

import blackjack.domain.card.Card;
import blackjack.domain.cards.PlayerCards;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final PlayerCards playerCards;
    private final String name;

    public Player(String name, List<Card> cards) {
        this.playerCards = new PlayerCards(cards);
        this.name = name;
    }

    public static List<Player> createPlayers(List<String> playerNames, Dealer dealer) {
        return playerNames.stream()
            .map(name -> new Player(name, dealer.getInitialPickedCards()))
            .collect(Collectors.toList());
    }

    public PlayerCards getPlayerCards() {
        return playerCards;
    }

    public String getName() {
        return name;
    }
}
