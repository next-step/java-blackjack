package blackjack.domain;

import java.util.ArrayList;

public class Player extends Participant {

    private static final String CARD_TAG = "카드: ";

    private final String name;

    public Player(Cards cards, String name) {
        super(cards);
        this.name = name;
    }

    public static Player from(String name) {
        Cards cards = new Cards(new ArrayList<>());
        return new Player(cards, name);
    }

    public String getName() {
        return name;
    }
}
