package blackjack.domain;

import java.util.Arrays;

public enum ResultValue {

    WIN(1, "승"),
    DRAW(0, "무"),
    LOSE(-1, "패");

    private static final String INVALID_KEY = "존재하지 않는 값입니다.";
    private int score;
    private String name;

    ResultValue(int score, String name) {
        this.score = score;
        this.name = name;
    }

    private static ResultValue create(int score) {
        return Arrays.stream(ResultValue.values()).filter(value -> value.score == score)
            .findFirst().orElseThrow(() -> new IllegalArgumentException(INVALID_KEY));
    }

    public ResultValue reverseScore() {
        return ResultValue.create(-score);
    }

    public String getName() {
        return name;
    }
}
