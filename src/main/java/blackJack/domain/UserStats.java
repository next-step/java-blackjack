package blackJack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class UserStats {

    private final GameUser gameUser;

    private UserStats(GameUser gameUser) {
        this.gameUser = gameUser;
    }

    public static UserStats of(GameUser gameUser) {
        return new UserStats(gameUser);
    }

    public GameUser getGameUser() {
        return gameUser;
    }

    public String convertTotalScore() {
        List<User> users = gameUser.getUsers();

        return users.stream().map(
            user -> String.format(
                "%s - 결과: %d\n",
                user.convertStatus(),
                user.getScore()
            )
        ).collect(Collectors.joining());
    }

    public String convertTotalResult() {

        return "";
    }
}