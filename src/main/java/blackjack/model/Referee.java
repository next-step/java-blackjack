package blackjack.model;

public class Referee {
    private static final int HAVE_COUNT = 0;
    private static final String WINNING_STATE_SEPARATOR = ": ";
    private static final String WIN = "승 ";
    private static final String DRAW = "무 ";
    private static final String LOSE = "패 ";

    private Referee() {
    }

    public static void makeWinningStates(Dealer dealer, Users users) {
        for (User user : users.getUsers()) {
            Referee.makeWinningState(dealer, user);
        }
    }

    public static void makeWinningState(Dealer dealer, User user) {
        if (dealer.isBust()) {
            dealerBustLogic(dealer, user);
            return;
        }

        if (user.isBust()) {
            userBustLogic(dealer, user);
            return;
        }

        comparePlayersLogic(dealer, user);
    }

    private static void dealerBustLogic(Dealer dealer, User user) {
        if (user.isBust()) {
            dealer.winning();
            user.losing();
        }

        boolean isNotUserBust = !user.isBust();

        if (isNotUserBust) {
            dealer.losing();
            user.winning();
        }
    }

    private static void userBustLogic(Dealer dealer, User user) {
        dealer.winning();
        user.losing();
    }

    private static void comparePlayersLogic(Dealer dealer, User user) {
        if (dealer.getCardValueSum() > user.getCardValueSum()) {
            dealer.winning();
            user.losing();
        }
        if (dealer.getCardValueSum() < user.getCardValueSum()) {
            dealer.losing();
            user.winning();
        }
        if (dealer.getCardValueSum() == user.getCardValueSum()) {
            dealer.drawing();
            user.drawing();
        }
    }

    public static String makeResult(Dealer dealer, Users users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(dealer.getName()).append(WINNING_STATE_SEPARATOR)
                .append(makeDealerResult(dealer));

        for (User user : users.getUsers()) {
            stringBuilder.append(user.getName())
                    .append(WINNING_STATE_SEPARATOR)
                    .append(makeUserResult(user));
        }

        return stringBuilder.toString();
    }

    private static StringBuilder makeDealerResult(Dealer dealer) {
        StringBuilder stringBuilder = new StringBuilder();

        if (dealer.getWinCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getWinCount())
                    .append(WIN);
        }
        if (dealer.getDrawCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getDrawCount())
                    .append(DRAW);
        }
        if (dealer.getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getLoseCount())
                    .append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }

    private static StringBuilder makeUserResult(User user) {
        StringBuilder stringBuilder = new StringBuilder();

        if (user.getWinCount() > HAVE_COUNT) {
            stringBuilder.append(WIN);
        }
        if (user.getDrawCount() > HAVE_COUNT) {
            stringBuilder.append(DRAW);
        }
        if (user.getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }
}