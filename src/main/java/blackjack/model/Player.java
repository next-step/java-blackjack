package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }
}
