package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Player extends CasinoPerson {
    private final int SCORE_LIMIT = 21;
    private String playerName;
    private List<Card> holdingCards = new ArrayList<>();


    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    boolean isDrawCard(int score) {
        return score <= SCORE_LIMIT;
    }

    @Override
    public void getCard(Card get_card) {
        this.holdingCards.add(get_card);
    }

    public List<Card> getHoldingCards() {
        return holdingCards;
    }
}
