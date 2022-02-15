package blackJack.domain;

import java.util.Arrays;
import java.util.List;

public class CardType {

    private static final List<String> CARD_TYPE_LIST = Arrays.asList("다이아몬드", "하트", "클로버", "스페이드");

    private String cardType;

    private CardType(String cardType) {
        this.cardType = cardType;

        validateCardNumberRange();
    }

    public static CardType from(String cardType) {
        return new CardType(cardType);
    }

    public String getType() {
        return cardType;
    }

    private void validateCardNumberRange() {
        if (!CARD_TYPE_LIST.contains(cardType)) {
            throw new RuntimeException("[ERROR] CardType 범위인 String을 입력해주세요.");
        }
    }
}
