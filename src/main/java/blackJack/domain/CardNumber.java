package blackJack.domain;

public class CardNumber {

    private static final String JQK_REGEX = "[JQK]";
    private static final int JQK_SCORE = 10;
    private static final int ACE_SCORE = 1;

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

    public int calculateScore() {
        String number = trumpNumber.getTrumpNumber();

        if (number.matches(JQK_REGEX)) {
            return JQK_SCORE;
        }
        if (number.equals(TrumpNumber.ACE.getTrumpNumber())) {
            return ACE_SCORE;
        }

        return Integer.parseInt(number);
    }
}
