package blackjack.domain.state;

import blackjack.domain.card.Cards;

public class Stay extends Finished {

    public Stay(final Cards cards) {
        super(cards);
    }
}
