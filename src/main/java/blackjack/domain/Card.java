package blackjack.domain;

import blackjack.dto.CardInfo;

import java.util.Objects;

public class Card {

    private final Denomination denomination;
    private final Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public Integer getScore() {
        return denomination.getScore();
    }

    public boolean isAce() {
        return denomination.isAce();
    }

    public CardInfo getCardInfo() {
        return new CardInfo(
                denomination,
                suit
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }
}
