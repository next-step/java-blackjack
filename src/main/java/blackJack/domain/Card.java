package blackJack.domain;

public class Card {

    private final CardType cardType;
    private final CardNumber cardNumber;

    private Card(String cardType, String cardNumber) {
        this.cardType = CardType.from(cardType);
        this.cardNumber = CardNumber.from(cardNumber);
    }

    public static Card of(String cardType, String cardNumber) {
        return new Card(cardType, cardNumber);
    }

    public boolean isAce() {
        return cardNumber.getNumber().equals(TrumpNumber.ACE.getTrumpNumber());
    }

    public int getCardScore() {
        return cardNumber.calculateScore();
    }

    public String getCardType() {
        return cardType.getType();
    }

    public String getCardNumber() {
        return cardNumber.getNumber();
    }
}

