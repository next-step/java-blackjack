package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Player extends CasinoPerson {
    private final int SCORE_LIMIT = 21;
    private final int ACE_MAX_SCORE = 11;
    private final String WIN = "승";
    private final String LOSE = "패";
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
        return gap(SCORE_LIMIT - (addedResult + CardNumber.ACE.getMinScore()), SCORE_LIMIT - (addedResult + CardNumber.ACE.getMaxScore()),
                addedResult);
    }

    private int gap(int minScore, int maxScore, int addedResult) {
        if (minScore <= maxScore || addedResult >= ACE_MAX_SCORE) {
            return CardNumber.ACE.getMinScore();
        }
        return CardNumber.ACE.getMaxScore();
    }

    public boolean compare(Dealer dealer) {
        if (!this.bust() && (dealer.bust() || dealer.sumCards() < sumCards())) {
            this.playerResult = WIN;
            return true;
        }
        this.playerResult = LOSE;
        return false;
    }

    private boolean bust() {
        return addedResult > SCORE_LIMIT;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Card> getHoldingCards() {
        return holdingCards;
    }

    public String getPlayerResult() {
        return playerResult;
    }
}
