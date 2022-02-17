package blackJack.domain;

import java.util.List;
import java.util.stream.Collectors;

public class UserStats {

    public static final String TOTAL_SCORE_FORMAT = "%s - 결과: %d\n";
    public static final String DEALER_TOTAL_FORMAT = "%s: %d승 %d패\n";
    public static final String PLAYER_WIN_FORMAT = "%s: 승\n";
    public static final String PLAYER_LOSE_FORMAT = "%s: 패\n";

    private final GameUser gameUser;

    private UserStats(GameUser gameUser) {
        this.gameUser = gameUser;
    }

    public static UserStats of(GameUser gameUser) {
        return new UserStats(gameUser);
    }

    public String convertTotalScore() {
        List<User> users = gameUser.getUsers();

        return users.stream().map(
            user -> String.format(
                TOTAL_SCORE_FORMAT,
                user.convertStatus(),
                user.getScore()
            )
        ).collect(Collectors.joining());
    }

    public String convertTotalResult() {
        return convertDealerTotalResult() + convertPlayersTotalResult();
    }

    public String convertDealerTotalResult() {
        int win = (int) gameUser.getPlayers().stream()
            .filter(this::isDealerWin)
            .count();
        int total = gameUser.getPlayers().size();
        return String.format(
            DEALER_TOTAL_FORMAT,
            gameUser.getDealer().getName(),
            win,
            (total - win)
        );
    }

    public String convertPlayersTotalResult() {
        return gameUser.getPlayers().stream()
            .map(player -> {
                if (!isDealerWin(player)) {
                    return String.format(PLAYER_WIN_FORMAT, player.getName());
                }
                return String.format(PLAYER_LOSE_FORMAT, player.getName());
            }).collect(Collectors.joining());
    }

    private boolean isDealerWin(Player player) {
        if (gameUser.getDealer().getScore() > Deck.MATCH_SCORE) {
            return false;
        }
        if (player.getScore() > Deck.MATCH_SCORE) {
            return true;
        }

        return player.getScore() < gameUser.getDealer().getScore();
    }
}
