package BlackJack.actor;

import BlackJack.card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CasinoPerson {

    private final int SCORE_LIMIT = 21;
    private final int ADD_ACE_NUMBER = 10;

    private List<Card> holdingCards = new ArrayList<>();
    private int addedResult;

    abstract public boolean isDrawCard(int score);

    public void getCard(Card get_card) {
        this.holdingCards.add(get_card);
    }

    public int sumCards() {
        addedResult = 0;
        holdingCards.stream().forEach(card -> {
            addedResult += card.getCardNumber().getScore();
        });
        if (holdingCards.stream().anyMatch(card -> card.isAce())) {
            addedResult += ADD_ACE_NUMBER;
        }
        return addedResult;
    }

    public boolean bust() {
        return addedResult > SCORE_LIMIT;
    }

    public List<Card> getHoldingCards() {
        return holdingCards;
    }

}
