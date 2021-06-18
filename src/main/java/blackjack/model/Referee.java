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
            dealer.getWinningState().plusDrawCount();
            user.getWinningState().plusDrawCount();
        }

        boolean isNotUserBust = !user.isBust();

        if (isNotUserBust) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
    }

    private static void userBustLogic(Dealer dealer, User user) {
        dealer.getWinningState().plusWinCount();
        user.getWinningState().plusLoseCount();
    }

    private static void comparePlayersLogic(Dealer dealer, User user) {
        if (dealer.getCardValueSum() > user.getCardValueSum()) {
            dealer.getWinningState().plusWinCount();
            user.getWinningState().plusLoseCount();
        }
        if (dealer.getCardValueSum() < user.getCardValueSum()) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
        if (dealer.getCardValueSum() == user.getCardValueSum()) {
            dealer.getWinningState().plusDrawCount();
            user.getWinningState().plusDrawCount();
        }
    }
}