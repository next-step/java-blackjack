package blackjack.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
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

    public String getCardName() {
        return denomination.getName() + suit.getName();
    }
}
