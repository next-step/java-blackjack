package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends CasinoPerson {
    private final String DEALER_NAME = "딜러";
    private final int SCORE_LIMIT = 16;
    private List<Card> holdingCards = new ArrayList<>();
    ;

    public Dealer() {
    }

    public Dealer(List<Card> holdingCards) {
        this.holdingCards = holdingCards;
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
