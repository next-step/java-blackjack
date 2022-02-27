package blackjack.domain.state;

import blackjack.domain.card.Cards;

public class Bust extends End {

    public Bust(final Cards cards) {
        super(cards);
    }

}
