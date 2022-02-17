package blackjack.domain.state;

import blackjack.domain.card.Cards;

public class State extends StateSupport {

    public State(Cards cards, boolean end) {
        super(cards, end);
    }

    @Override
    public Gameable judge() {
        if (cards.sum()) {
            return new State(cards, false);
        }
        return new State(cards, true);
    }
}


