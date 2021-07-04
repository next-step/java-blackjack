package blackjack.model.state;

import blackjack.model.BunchOfCard;

public class Stay extends Finished {
    public Stay(BunchOfCard bunchOfCard) {
        super(bunchOfCard);
    }

    @Override
    double earningRate() {
        return 1;
    }
}
