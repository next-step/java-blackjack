package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class Play extends Started{

    public Play(final Cards cards) { super(cards); }

    @Override
    public boolean isEnd() {
        return false;
    }

}
