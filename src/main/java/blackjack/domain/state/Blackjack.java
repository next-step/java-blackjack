package blackjack.domain.state;

import blackjack.domain.card.Cards;

public class Blackjack extends Finished {

    public Blackjack(final Cards cards) {
        super(cards);
    }
}
