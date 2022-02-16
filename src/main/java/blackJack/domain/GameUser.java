package blackJack.domain;

import java.util.ArrayList;
import java.util.List;

public class GameUser {

    private final List<User> gameUsers;

    private GameUser() {
        this.gameUsers = new ArrayList<>();
    }

    public static GameUser create() {
        return new GameUser();
    }

    public List<User> getGameUsers() {
        return gameUsers;
    }

    public GameUser append(User user) {
        gameUsers.add(user);
        return this;
    }
}
