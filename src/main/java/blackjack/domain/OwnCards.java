package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class OwnCards {

    private final int BLACKJACK = 21;
    private final int ACE_NUMBER_TEN = 10;
    private final int ACE_NUMBER_ONE = 1;

    private final List<Card> ownCards;

    public OwnCards() {
        this.ownCards = new ArrayList<>();
    }

    public int getTotalScore() {
        int total = ownCards.stream().mapToInt(Card::getCardNumber).sum();

        if (total <= BLACKJACK - ACE_NUMBER_TEN && ownCards.stream().anyMatch(Card::isAceCard)) {
            return total + ACE_NUMBER_TEN - ACE_NUMBER_ONE;
        }

        return total;
    }

    public boolean isScoreLimit() {
        return getTotalScore() > BLACKJACK;
    }

    public boolean isBlackJack() {
        return getTotalScore() == BLACKJACK;
    }

    public void addCard(Card card) {
        ownCards.add(card);
    }

    public List<Card> getOwnCards() {
        return ownCards;
    }
}
