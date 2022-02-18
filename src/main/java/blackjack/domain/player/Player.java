package blackjack.domain.player;

import blackjack.domain.state.Gameable;

public class Player extends Person {

    private final Gameable cards;

    public Player(final String name, final Gameable cards) {
        super(name);
        this.cards = cards;
    }

    public Gameable getCards() {
        return cards;
    }
}
