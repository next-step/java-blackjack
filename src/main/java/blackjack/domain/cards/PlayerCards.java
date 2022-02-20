package blackjack.domain.cards;

import blackjack.domain.card.Card;
import java.util.List;

public class PlayerCards extends PersonCards {

    private static final int PLAYER_MAXIMUM_SUM = 21;

    public PlayerCards(List<Card> cards) {
        super(cards);
    }

    @Override
    public boolean canReceiveMoreCard() {
        return sum <= PLAYER_MAXIMUM_SUM;
    }
}
