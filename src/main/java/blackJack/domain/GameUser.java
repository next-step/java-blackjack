package blackJack.domain;

import java.util.ArrayList;
import java.util.List;

public class GameUser {

    private final List<User> gameUsers;

    private GameUser(List<String> userNames) {
        this.gameUsers = new ArrayList<>();

        this.append(Dealer.create());
        userNames.forEach(userName -> this.append(Player.of(userName)));
    }

    public static GameUser from(List<String> userNames) {
        return new GameUser(userNames);
    }

    public List<User> getGameUsers() {
        return gameUsers;
    }

    public GameUser append(User user) {
        gameUsers.add(user);
        return this;
    }
}
