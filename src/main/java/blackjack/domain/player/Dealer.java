package blackjack.domain.player;

import blackjack.domain.state.Gameable;

public class Dealer extends Person {

    private final Gameable cards;

    public Dealer(String name, Gameable cards) {
        super(name);
        this.cards = cards;
    }

    public Gameable getCards() {
        return cards;
    }
}
