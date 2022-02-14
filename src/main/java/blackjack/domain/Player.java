package blackjack.domain;

import java.util.ArrayList;

public class Player {

    private final String name;
    private int score;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.cards = new ArrayList<>();
    }
}
