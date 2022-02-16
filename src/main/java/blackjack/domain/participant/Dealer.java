package blackjack.domain.participant;

import blackjack.domain.card.Hands;

public class Dealer extends Participant {

    private static final int DRAWABLE_SCORE_LIMIT = 17;

    public Dealer(Hands hands) {
        super(hands);
    }

    @Override
    boolean canDraw() {
        return hands.isUnderScore(DRAWABLE_SCORE_LIMIT);
    }
}