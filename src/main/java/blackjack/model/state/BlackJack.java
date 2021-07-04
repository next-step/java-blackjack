package blackjack.model.state;

import blackjack.model.BunchOfCard;

public class BlackJack extends Finished {
    public BlackJack(BunchOfCard bunchOfCard) {
        super(bunchOfCard);
    }

    @Override
    double earningRate() {
        return 1.5;
    }
}