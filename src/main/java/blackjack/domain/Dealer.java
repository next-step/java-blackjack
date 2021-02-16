package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer implements GameParticipant {
    private static final int BLACKJACK = 21;
    private static final int ACE_BONUS= 10;
    private static final int CRITERIA = 17;
    private static final String NAME = "딜러";
    private static final List<Card> cards = new ArrayList<>();

    @Override
    public void hit(Card card) {
        this.cards.add(card);
    }

    @Override
    public List<Card> getCardsBeforeGameStart() {
        return Collections.singletonList(this.cards.get(0));
    }

    @Override
    public String getName() {
        return this.NAME;
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public int getResult() {
        int score = 0;
        boolean hasAce = false;
        for (Card card : cards) {
            int cardNumber = card.getDenomination().getNumber();
            score += cardNumber;
            hasAce = hasAce || checkAce(cardNumber);
        }
        if (hasAce && score + ACE_BONUS <= BLACKJACK) {
            score += ACE_BONUS;
        }
        return score;
    }

    @Override
    public boolean checkAce(int cardNumber) {
        return cardNumber == 1;
    }

    public boolean isActive() {
        return getResult() < CRITERIA;
    }
}
