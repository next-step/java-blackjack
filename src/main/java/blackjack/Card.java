package blackjack;

import java.util.Objects;

public class Card {

    private final Suit suit;
    private final CardNumber cardNumber;
    public Card(Suit suit,CardNumber cardNumber) {
        this.suit = suit;
        this.cardNumber=cardNumber;
    }

    public int getCardScore() {
        return cardNumber.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Card card = (Card) o;
        return suit == card.suit && cardNumber == card.cardNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, cardNumber);
    }
}
