package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class End extends Started {

    public End(Cards cards) {
        super(cards);
    }

    @Override
    public Gameable draw() {
        return null;
    }

    @Override
    public Gameable stay() {
        return null;
    }

    @Override
    public boolean isEnd() {
        return true;
    }


}
