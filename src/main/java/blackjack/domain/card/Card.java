package blackjack.domain.card;

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
}
