package blackjack;

import java.util.List;

public class Dealer {
    private final BunchOfCard bunchOfCard;

    public Dealer() {
        this.bunchOfCard = new BunchOfCard();
    }

    public void addCard(Card card) {
        this.bunchOfCard.addCard(card);
    }

    public int getCardValueSum() {
        return this.bunchOfCard.getCardValueSum();
    }

    public List<String> getCardNames() {
        return bunchOfCard.getCardNames();
    }
}
