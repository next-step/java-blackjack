package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Hands;
import java.util.List;

public class Player extends Participant {

    private static final int DRAWABLE_SCORE_LIMIT = 21;

    private final String name;

    public Player(final String name, List<Card> cards) {
        super(new Hands(cards));
        this.name = name;
    }

    @Override
    public boolean canDraw() {
        return hands.isUnderScore(DRAWABLE_SCORE_LIMIT);
    }

    @Override
    public String getName() {
        return name;
    }
}
