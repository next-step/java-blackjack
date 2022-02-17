package blackjack.domain;

public class State extends Over {

    public State(Cards cards) {
        super(cards);
    }

    @Override
    public CardAddible judge() {
        if (cards.sum()) {
            return new State(cards);
        }
        return new Continue(cards);
    }
}


