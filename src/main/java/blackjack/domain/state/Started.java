package blackjack.domain.state;

import blackjack.domain.card.Cards;

public abstract class Started implements State {

    public Cards cards;

    public Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }
}
