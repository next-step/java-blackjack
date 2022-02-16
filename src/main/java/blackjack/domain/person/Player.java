package blackjack.domain.person;

import blackjack.domain.card.Card;
import java.util.List;

public class Player extends Person {

    private final String name;

    public Player(String name, List<Card> cards) {
        this.name = name;
        this.cards.addAll(cards);
    }

    public String getName() {
        return name;
    }
}
