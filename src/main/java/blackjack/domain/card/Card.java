package blackjack.domain.card;

import blackjack.domain.player.Denomination;
import blackjack.domain.player.Suit;

public class Card {

    private Denomination denomination;
    private Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return this.denomination;
    }

    public Suit getSuit() {
        return this.suit;
    }
}
