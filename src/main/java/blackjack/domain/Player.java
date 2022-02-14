package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player extends Gambler {

    public Player(final String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    @Override
    protected int calculateScore() {
        return 0;
    }

    @Override
    protected void receiveCard() {

    }


}
