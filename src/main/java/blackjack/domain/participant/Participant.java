package blackjack.domain.participant;

import blackjack.domain.card.Card;
import blackjack.domain.card.Hands;
import java.util.List;

public abstract class Participant {

    protected final Hands hands;

    Participant(final Hands hands) {
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

    public void addCard(final Card card) {
        hands.add(card);
    }
}
