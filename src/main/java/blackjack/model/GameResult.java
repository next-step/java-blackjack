package blackjack.model;

import blackjack.view.Output;

import java.util.List;

public class GameResult {
    private static final int HAVE_COUNT = 0;
    private static final String WINNING_STATE_SEPARATOR = ": ";
    private static final String WIN = "승 ";
    private static final String LOSE = "패 ";

    private Player dealer;
    private Players users;

    public GameResult(Player dealer, Players users){
        this.dealer = dealer;
        this.users = users;
    }

    public String makeResultLogic(Player dealer, Players users) {
        String result = makeResult(dealer, users.getUser());
        return  result;
    }

    private String makeResult(Player dealer, List<Player> users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(dealer.getName()).append(WINNING_STATE_SEPARATOR)
                .append(makeDealerResult(dealer));

        for (Player user : users) {
            stringBuilder.append(user.getName())
                    .append(WINNING_STATE_SEPARATOR)
                    .append(makeUserResult(user));
        }

        return stringBuilder.toString();
    }

    private StringBuilder makeDealerResult(Player dealer) {
        StringBuilder stringBuilder = new StringBuilder();
        if (dealer.getWinningState().getWinCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getWinningState().getWinCount())
                    .append(WIN);
        }
        if (dealer.getWinningState().getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getWinningState().getLoseCount())
                    .append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }

    private StringBuilder makeUserResult(Player user) {
        StringBuilder stringBuilder = new StringBuilder();

        if (user.getWinningState().getWinCount() > HAVE_COUNT) {
            stringBuilder.append(WIN);
        }
        if (user.getWinningState().getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }
}
