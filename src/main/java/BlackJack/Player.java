package BlackJack;

import java.util.List;

public class Player extends CasinoPerson{
    private final int SCORE_LIMIT = 21;
    private String playerName;
    private List<Card> holdingCards;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player(String playerName, List<Card> holdingCards) {
        this.playerName = playerName;
        this.holdingCards = holdingCards;
    }

    @Override
    boolean isDrawCard(int score) {
        return score <= SCORE_LIMIT;
    }
}
