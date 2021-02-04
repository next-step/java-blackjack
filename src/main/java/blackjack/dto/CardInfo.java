package blackjack.dto;

import blackjack.domain.Denomination;
import blackjack.domain.Suit;

public class CardInfo {
    private final Denomination denomination;
    private final Suit suit;

    public CardInfo(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }
}
