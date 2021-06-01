package blackjack;

public class Player {
    private final String name;

    public Player(String name) {
        validateNullInput(name);
        this.name = name;
    }

    private void validateNullInput(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름을 입력하지 않으면 생성할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
