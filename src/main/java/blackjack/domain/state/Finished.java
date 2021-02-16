package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class Finished extends Started {

    public Finished(final Cards cards) {
        super(cards);
    }

    @Override
    public State draw(PlayingCard playingCard) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
