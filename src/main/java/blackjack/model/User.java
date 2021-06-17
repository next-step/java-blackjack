package blackjack.model;

import blackjack.model.state.State;

public class User extends Player {
    private static final String DO_NOT_INPUT_NULL_MESSAGE = "이름을 입력하지 않으면 생성할 수 없습니다.";
    private final String name;

    public User(String name, State state) {
        super(state);

        validateNullInput(name);
        this.name = name;
    }

    private static void validateNullInput(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(DO_NOT_INPUT_NULL_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }
}
