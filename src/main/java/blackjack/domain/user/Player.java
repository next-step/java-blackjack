package blackjack.domain.user;

public class Player {

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public String name() {
        return name;
    }
}
