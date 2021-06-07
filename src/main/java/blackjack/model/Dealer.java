package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Player {
    private static final int RECEIVE_CARD_CONDITION = 17;
    private static final int FIRST_INDEX = 0;

    private final BunchOfCard bunchOfCard;

    public Dealer() {
        this.bunchOfCard = new BunchOfCard();
    }

    @Override
    public void addCard(Card card) {
        this.bunchOfCard.addCard(card);
    }

    @Override
    public void addSeveralCard(List<Card> cards) {
        for (Card card : cards) {
            addCard(card);
        }
    }

    @Override
    public int getCardValueSum() {
        return this.bunchOfCard.getCardValueSum();
    }

    @Override
    public List<String> getCardNames() {
        return bunchOfCard.getCardNames();
    }

    @Override
    public boolean canReceiveCard() {
        return getCardValueSum() < RECEIVE_CARD_CONDITION;
    }

    public List<String> getCardName() {
        ArrayList<String> cardName = new ArrayList<>();
        cardName.add(getCardNames().get(FIRST_INDEX));

        return cardName;
    }
}
