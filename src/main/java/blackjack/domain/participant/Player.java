package blackjack.domain.participant;

import blackjack.domain.card.Hands;

public class Player extends Participant {

    private static final int DRAWABLE_SCORE_LIMIT = 21;

    public Player(Hands hands) {
        super(hands);
    }

    @Override
    boolean canDraw() {
         return hands.isUnderScore(DRAWABLE_SCORE_LIMIT);
    }
}
