package blackjack.domain;

public class Player {
    private final String name;

    public Player(final String name) {
        validateNonEmptyName(name);
        this.name = name;
    }

    private void validateNonEmptyName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름으로 사용할 수 없습니다.");
        }
    }

    @Override
    public String getName() {
        return this.name;
    }
}
