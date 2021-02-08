package blackjack.dto;

import blackjack.domain.Denomination;
import blackjack.domain.Suit;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardInfo cardInfo = (CardInfo) o;
        return denomination == cardInfo.denomination && suit == cardInfo.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }
}
