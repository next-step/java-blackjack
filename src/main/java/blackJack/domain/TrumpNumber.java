package blackJack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TrumpNumber {
    ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
    EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");

    private final String trumpNumber;

    TrumpNumber(String trumpNumber) {
        this.trumpNumber = trumpNumber;
    }

    public static List<String> trumpNumbers() {
        return Arrays.stream(values())
            .map(TrumpNumber::getTrumpNumber)
            .collect(Collectors.toList());
    }

    public static TrumpNumber from(String cardNumber) {
        return Arrays.stream(values())
            .filter(trumpNumber -> trumpNumber.getTrumpNumber().equals(cardNumber))
            .findAny()
            .orElseThrow(() -> new RuntimeException("[ERROR] CardNumber 범위인 String을 입력해주세요."));
    }

    public String getTrumpNumber() {
        return trumpNumber;
    }
}
