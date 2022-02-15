package blackJack.domain;

public class CardNumber {

    private String cardNumber;

    private CardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static CardNumber from(String cardNumber) {
        return new CardNumber(cardNumber);
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
