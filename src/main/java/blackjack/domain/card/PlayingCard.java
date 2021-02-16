package blackjack.domain.card;

import blackjack.domain.player.Denomination;
import blackjack.domain.player.Suit;

public class PlayingCard {

    private Denomination denomination;
    private Suit suit;
    private boolean flipped = true;

    public boolean isFlipped() {
        return flipped;
    }

    public void flip() {
        this.flipped = false;
    }

    public PlayingCard(Denomination denomination, Suit suit) {
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
