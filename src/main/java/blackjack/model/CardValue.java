package blackjack.model;

import java.util.HashMap;
import java.util.Map;

public enum CardValue {
    ACE("1", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5),
    SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8), NINE("9", 9), TEN("10", 10),
    JACK("J", 10), QUEEN("Q", 10), KING("K", 10);

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 13;
    private static final Map<Integer, CardValue> cardValues = new HashMap<>();

    static {
        //TODO : 정해지지 않은 index를 가지고 처리한다.
        for (int i = MIN_VALUE; i < MAX_VALUE + 1; i++) {
            cardValues.put(i, values()[i - 1]);
        }
    }

    private final String tag;
    private final int score;

    CardValue(String tag, int score) {
        this.tag = tag;
        this.score = score;
    }

    public String getTag() {
        return tag;
    }

    public int getScore() {
        return score;
    }

    public static CardValue of(final int value) {
        validate(value);
        return cardValues.get(value);
    }

    private static void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("카드의 숫자는 1에서 13까지 사용할 수 있습니다.");
        }
    }
}