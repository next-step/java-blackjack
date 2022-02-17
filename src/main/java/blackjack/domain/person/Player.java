package blackjack.domain.person;

import blackjack.domain.card.Card;
import java.util.List;
import java.util.stream.Collectors;

public class Player extends Person {

    private final String name;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards.addAll(cards);
    }

    public static List<Player> createPlayers(List<String> playerNames, Dealer dealer) {
        return playerNames.stream()
            .map(name -> new Player(name, dealer.getInitialPickedCards()))
            .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }
}
