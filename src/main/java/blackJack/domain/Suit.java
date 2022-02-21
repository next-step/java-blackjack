package blackJack.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Suit {
    DIAMOND("다이아몬드"),
    HEART("하트"),
    SPADE("스페이드"),
    CLOVER("클로버");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    public static List<String> getSuits() {
        return Arrays.stream(values())
            .map(Suit::getName)
            .collect(Collectors.toList());
    }

    public static Suit from(String cardType) {
        return Arrays.stream(values())
            .filter(suit -> suit.getName().equals(cardType))
            .findAny()
            .orElseThrow(() -> new RuntimeException("[ERROR] CardType 범위인 String을 입력해주세요."));
    }

    public String getName() {
        return name;
    }
}
