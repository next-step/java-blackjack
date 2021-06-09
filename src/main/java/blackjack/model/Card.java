package blackjack.model;

public class Card {
    private CardPattern cardPattern;
    private CardNumber cardNumber;

    public Card(CardPattern cardPattern, CardNumber cardNumber) {
        this.cardPattern = cardPattern;
        this.cardNumber = cardNumber;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public CardPattern getCardPattern() {
        return cardPattern;
    }
}
