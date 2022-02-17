package blackjack.domain.gameplayer;

public class Name {

    private static final String PLAYER_NAME_ERROR_MESSAGE = "이름은 공백이 들어올 수 없습니다.";

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(PLAYER_NAME_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
    }
}
