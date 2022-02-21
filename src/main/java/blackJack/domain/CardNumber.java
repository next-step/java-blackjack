package blackJack.domain;

public class CardNumber {

    private final TrumpNumber trumpNumber;

    private CardNumber(String cardNumber) {
        this.trumpNumber = TrumpNumber.from(cardNumber);
    }

    public static CardNumber from(String cardNumber) {
        return new CardNumber(cardNumber);
    }

    public String getNumber() {
        return trumpNumber.getTrumpNumber();
    }
}
