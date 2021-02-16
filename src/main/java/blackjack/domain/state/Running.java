package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class Running extends Started {

    public Running(final Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
