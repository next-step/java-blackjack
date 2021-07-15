package blackjack.model;

import blackjack.model.strategy.DealerReceiveCardStrategy;
import blackjack.model.strategy.UserReceiveCardStrategy;

public class PlayerFactory {
    public static final String DEALER = "딜러";
    private static final String DO_NOT_INPUT_NULL_MESSAGE = "이름을 입력하지 않으면 생성할 수 없습니다.";

    private PlayerFactory(){}

    public static Player of(String name) {
        validateNullInput(name);

        if (name.equals(DEALER)) {
            return new Player(name, new DealerReceiveCardStrategy());
        }

        return new Player(name, new UserReceiveCardStrategy());
    }

    private static void validateNullInput(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(DO_NOT_INPUT_NULL_MESSAGE);
        }
    }
}
