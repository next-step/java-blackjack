package blackjack.domain.participant;

import blackjack.domain.card.Hands;
import java.util.Arrays;
import java.util.List;

public abstract class Participant {

    protected final Hands hands;

    public Participant(final Hands hands) {
        this.hands = hands;
    }

    abstract public boolean canDraw();

    abstract public String getName();

    public int getScore() {
        return hands.getScore();
    }

    public List<String> getCardNames() {
        return hands.getCardNames();
    }
}
