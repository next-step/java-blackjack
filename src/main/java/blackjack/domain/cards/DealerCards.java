package blackjack.domain.cards;

import blackjack.domain.card.Card;
import java.util.List;

public class DealerCards extends PersonCards {

    private static final int DEALER_MAXIMUM_SUM = 16;

    public DealerCards(List<Card> cards) {
        super(cards);
    }

    @Override
    public boolean canReceiveMoreCard() {
        return sum <= DEALER_MAXIMUM_SUM;
    }

    public Card getCardByIndex(int index) {
        return cards.get(index);
    }
}
