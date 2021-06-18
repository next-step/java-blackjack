package blackjack.model;

public class Referee {

    private Referee() {
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
            dealer.drawing();
            user.drawing();
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
}