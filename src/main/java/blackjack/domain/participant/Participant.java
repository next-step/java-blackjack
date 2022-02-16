package blackjack.domain.participant;

import blackjack.domain.card.Hands;

public abstract class Participant {

    protected final Hands hands;

    public Participant(Hands hands) {
        this.hands = hands;
    }

    abstract boolean canDraw();

    public int getScore() {
        return hands.getScore();
    }
}
