package blackjack.domain;

import java.util.Objects;

public class Card {

    private static final String CARD_NAME_FORMAT = "%s%s";

    private final CardNumber cardNumber;
    private final Suit suit;

    public Card(CardNumber cardNumber, Suit suit) {
        this.cardNumber = cardNumber;
        this.suit = suit;
    }

    public boolean isAce() {
        return cardNumber.isAce();
    }

    public String getCardName() {
        return String.format(CARD_NAME_FORMAT, cardNumber.getInitial(), suit.getName());
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
