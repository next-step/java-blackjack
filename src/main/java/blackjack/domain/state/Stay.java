package blackjack.domain.state;

import blackjack.domain.card.Cards;

public class Stay extends End{

    public Stay(final Cards cards) {
        super(cards);
    }
}
