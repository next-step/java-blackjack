package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Player extends CasinoPerson {
    private final int SCORE_LIMIT = 21;
    private String playerName;
    private List<Card> holdingCards = new ArrayList<>();
    private int addedResult;
    private String playerResult;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    boolean isDrawCard(int score) {
        return score < SCORE_LIMIT;
    }

    @Override
    public void getCard(Card get_card) {
        this.holdingCards.add(get_card);
    }

    public int sumCards() {
        addedResult = 0;
        for (Card card : holdingCards) {
            addedResult += findCardNumber(card.getCardNumber());
        }
        return addedResult;
    }

    private int findCardNumber(CardNumber cardNumber) {
        if (cardNumber.equals(CardNumber.ACE)) {
            return findAceCondition(addedResult);
        }
        return cardNumber.getScore();
    }

    private int findAceCondition(int addedResult) {
        int aceScore = 0;
        int minScore = SCORE_LIMIT - (addedResult + CardNumber.ACE.getMinScore());
        int maxScore = SCORE_LIMIT - (addedResult + CardNumber.ACE.getMaxScore());

        aceScore = gap(minScore, maxScore, addedResult);
        return aceScore;
    }

    private int gap(int minScore, int maxScore, int addedResult) {
        if (minScore <= maxScore || addedResult >= 11) {
            return CardNumber.ACE.getMinScore();
        }
        return CardNumber.ACE.getMaxScore();
    }

    public boolean compare(int dealerScore) {
        bust();
        int playerDifference = SCORE_LIMIT - this.sumCards();
        int dealerDifference = SCORE_LIMIT - dealerScore;
        if (dealerScore <= SCORE_LIMIT && playerDifference < dealerDifference) {
            this.playerResult = "패";
            return true;
        }
        this.playerResult = "승";
        return false;
    }

    private void bust() {
        if (this.sumCards() > SCORE_LIMIT) {
            this.playerResult = "패";
        }
    }

    public String getPlayerName() {
        return playerName;    }

    public List<Card> getHoldingCards() {
        return holdingCards;
    }

    public String getPlayerResult() {
        return playerResult;
    }
}
