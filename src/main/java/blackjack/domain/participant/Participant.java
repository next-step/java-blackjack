package blackjack.domain.participant;

import blackjack.domain.card.Hands;

public abstract class Participant {

    protected final Hands hands;

    public Participant(final Hands hands) {
        this.hands = hands;
    }

    abstract boolean canDraw();

    abstract public String getName();

    public int getScore() {
        return hands.getScore();
    }
}
