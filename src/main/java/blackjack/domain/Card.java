package blackjack.domain;

public class Card {

    private final CardNumber cardNumber;
    private final CardType cardType;

    public Card(CardNumber cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardNumber.getName();
    }

    public int getCardNumber() {
        return cardNumber.getScore();
    }

    public String getCardType() {
        return cardType.getType();
    }

    public boolean isAceCard() {
        return cardNumber.isAce();
    }
}
