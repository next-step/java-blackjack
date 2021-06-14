package blackjackgame.model.player;

import blackjack.model.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private String name;
    private List<Card> cards = new ArrayList<>();
    private int score;

}
