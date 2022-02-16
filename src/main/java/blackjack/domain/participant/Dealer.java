package blackjack.domain.participant;

import blackjack.domain.card.Hands;

public class Dealer extends Participant {

    private static final String DEALER = "딜러";
    private static final int DRAWABLE_SCORE_LIMIT = 17;

    public Dealer(final Hands hands) {
        super(hands);
    }

    @Override
    public boolean canDraw() {
        return hands.isUnderScore(DRAWABLE_SCORE_LIMIT);
    }

    @Override
    public String getName() {
        return DEALER;
    }
}