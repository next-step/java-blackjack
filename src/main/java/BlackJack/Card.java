package BlackJack;

public class Card {
    private CardShape cardShape;
    private CardNumber cardNumber;

    public Card(CardShape cardShape, CardNumber cardNumber) {
        this.cardShape = cardShape;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardShape=" + cardShape +
                ", cardNumber=" + cardNumber +
                '}';
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }

}
