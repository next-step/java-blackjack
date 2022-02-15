package blackjack.domain.person;

import blackjack.domain.card.Card;

public class Player extends Person {

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
