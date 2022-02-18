package blackJack.domain;

import static blackJack.domain.CardNumber.ACE_INDEX;
import static blackJack.domain.CardNumber.CARD_NUMBER_LIST;

public class Card {

    private static final String JQK_REGEX = "[JQK]";
    private static final int JQK_SCORE = 10;
    private static final int ACE_SCORE = 1;

    private final CardType cardType;
    private final CardNumber cardNumber;

    private Card(String cardType, String cardNumber) {
        this.cardType = CardType.from(cardType);
        this.cardNumber = CardNumber.from(cardNumber);
    }

    public static Card of(String cardType, String cardNumber) {
        return new Card(cardType, cardNumber);
    }

    public String getCardType() {
        return cardType.getType();
    }

    public String getCardNumber() {
        return cardNumber.getNumber();
    }

    public int calculateCardScore() {
        String number = cardNumber.getNumber();

        if (number.matches(JQK_REGEX)) {
            return JQK_SCORE;
        }
        if (number.equals(CARD_NUMBER_LIST.get(ACE_INDEX))) {
            return ACE_SCORE;
        }

        return Integer.parseInt(number);
    }
}

