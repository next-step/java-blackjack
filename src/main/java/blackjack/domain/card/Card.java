package blackjack.domain.card;

public class Card {

    private final CardNumber cardNumber;
    private final CardPattern cardPattern;

    public Card(final CardNumber cardNumber, final CardPattern cardPattern) {
        this.cardNumber = cardNumber;
        this.cardPattern = cardPattern;
    }
    
    @Override
    public String toString() {
        return cardNumber.getName() + cardPattern.getName();
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }
}
