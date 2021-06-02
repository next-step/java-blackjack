package blackjack.model;

import java.util.List;

public class Dealer implements Player {
    private final BunchOfCard bunchOfCard;

    public Dealer() {
        this.bunchOfCard = new BunchOfCard();
    }

    @Override
    public void addCard(Card card) {
        this.bunchOfCard.addCard(card);
    }

    @Override
    public void addSeveralCard(List<Card> cards){
        for(Card card : cards){
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
}
