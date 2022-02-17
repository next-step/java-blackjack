package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Hands;
import java.util.List;

public class Dealer extends Participant {

    private static final String DEALER = "딜러";
    private static final int DRAWABLE_SCORE_LIMIT = 17;

    public Dealer(final List<Card> cards) {
        super(new Hands(cards));
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
