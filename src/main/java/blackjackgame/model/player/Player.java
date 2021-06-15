package blackjackgame.model.player;

import blackjack.model.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    String name;
    List<Card> cards = new ArrayList<>();
    int score;

}
