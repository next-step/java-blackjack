package blackjack.domain.card;

import java.util.Objects;

public class Card {

    private final CardSymbol cardSymbol;
    private final CardType cardType;

    public Card(final CardSymbol cardSymbol, final CardType cardType) {
        this.cardSymbol = cardSymbol;
        this.cardType = cardType;
    }

    public CardSymbol getCardSymbol() {
        return cardSymbol;
    }

    public CardType getCardType() {
        return cardType;
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
        return cardSymbol == card.cardSymbol && cardType == card.cardType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardSymbol, cardType);
    }
}
