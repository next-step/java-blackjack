package blackJack.domain;

public class Card {

    private CardType cardType;
    private CardNumber cardNumber;

    private Card(String cardType, String cardNumber) {
        this.cardType = CardType.from(cardType);
        this.cardNumber = CardNumber.from(cardNumber);
    }

    public static Card of(String cardType, String cardNumber) {
        return new Card(cardType, cardNumber);
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardNumber getCardNumber() {
        return cardNumber;
    }
}

