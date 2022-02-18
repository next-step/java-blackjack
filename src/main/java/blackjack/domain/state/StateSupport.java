package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class StateSupport extends CardSupport {

    boolean end;

    public StateSupport(final Cards card, boolean end) {
        super(card);
        this.end = end;
    }

    @Override
    public boolean isEnd() {
        return end;
    }
}
