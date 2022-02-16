package blackjack.domain.participant;

import blackjack.domain.card.Hands;

public class Player extends Participant {

    private static final int DRAWABLE_SCORE_LIMIT = 21;

    private final String name;

    public Player(final String name, final Hands hands) {
        super(hands);
        this.name = name;
    }

    @Override
    boolean canDraw() {
        return hands.isUnderScore(DRAWABLE_SCORE_LIMIT);
    }

    @Override
    public String getName() {
        return name;
    }
}
