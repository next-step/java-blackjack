package BlackJack.card;

public class Card {
    private CardShape cardShape;
    private CardNumber cardNumber;

    public Card(CardShape cardShape, CardNumber cardNumber) {
        this.cardShape = cardShape;
        this.cardNumber = cardNumber;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

    public CardShape getCardShape() {
        return cardShape;
    }

    public boolean isAce() {
        return cardNumber == CardNumber.ACE;
    }
}
