package blackJack.domain;

import java.util.Arrays;
import java.util.List;

public class CardNumber {

    private static final List<String> CARD_NUMBER_LIST = Arrays.asList("A", "2", "3", "4", "5", "6",
        "7", "8", "9", "10", "J", "Q", "K");

    private String cardNumber;

    private CardNumber(String cardNumber) {
        this.cardNumber = cardNumber;

        validateCardNumberRange();
    }

    public static CardNumber from(String cardNumber) {
        return new CardNumber(cardNumber);
    }

    public String getNumber() {
        return cardNumber;
    }

    private void validateCardNumberRange() {
        if (!CARD_NUMBER_LIST.contains(cardNumber)) {
            throw new RuntimeException("[ERROR] CardNumber 범위인 String을 입력해주세요.");
        }
    }
}
