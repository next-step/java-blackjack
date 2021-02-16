package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.player.Denomination;
import blackjack.domain.player.Suit;

public class PlayingCard extends Card {
    public PlayingCard(Denomination denomination, Suit suit) {
        super(denomination, suit);
    }
}
