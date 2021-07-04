package blackjack.model.state;

import blackjack.model.BunchOfCard;

public class Bust extends Finished {
    public Bust(BunchOfCard bunchOfCard) {
        super(bunchOfCard);
    }

    @Override
    double earningRate() {
        return -1;
    }
}
