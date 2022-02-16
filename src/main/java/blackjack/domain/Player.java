package blackjack.domain;


import static blackjack.utils.Constant.BUST_LIMIT;

import java.util.ArrayList;

public class Player extends Participant {

    private final String name;

    public Player(Cards cards, String name) {
        super(cards);
        this.name = name;
    }

    public static Player from(String name) {
        Cards cards = new Cards(new ArrayList<>());
        return new Player(cards, name);
    }

}
