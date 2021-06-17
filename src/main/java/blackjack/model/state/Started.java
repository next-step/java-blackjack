package blackjack.model.state;

import blackjack.model.BunchOfCard;

public abstract class Started implements State {
    protected final BunchOfCard bunchOfCard;

    protected Started(BunchOfCard bunchOfCard) {
        this.bunchOfCard = new BunchOfCard(bunchOfCard);
    }


    @Override
    public BunchOfCard getBunchOfCard() {
        return this.bunchOfCard;
    }
}
