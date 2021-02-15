package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer implements GameParticipant {
    private final String NAME = "딜러";
    private final List<Card> cards = new ArrayList<>();
    private final int CRITERIA = 17;

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
            if (cardNumber == 1) {
                hasAce = true;
            }
        }
        if (hasAce && score + 10 <= 21) {
            score += 10;
        }
        return score;
    }

    public boolean isActive() {
        return getResult() < CRITERIA;
    }
}
