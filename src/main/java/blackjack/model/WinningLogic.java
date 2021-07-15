package blackjack.model;

import blackjack.controller.BlackJackController;

public class WinningLogic {
    private Player dealer;
    private Players users;

    public WinningLogic(Player dealer,Players users){
        this.dealer = dealer;
        this.users = users;
        makeWinningStateLogic(dealer,users);
    }

    private void makeWinningStateLogic(Player dealer, Players users) {
        for (Player user : users.getUser()) {
            makeWinningState(dealer, user);
        }
    }

    private void makeWinningState(Player dealer, Player user) {
        if (isDealerBurst(dealer)) {
            dealerLoseLogic(dealer, user);
            return;
        }

        if (isUserBurst(user)) {
            userLoseLogic(dealer, user);
            return;
        }

        comparePlayersLogic(dealer, user);
    }

    private boolean isDealerBurst(Player dealer) {
        return burstCheck(dealer);
    }

    private boolean isUserBurst(Player user) {
        return burstCheck(user);
    }

    private void dealerLoseLogic(Player dealer, Player user) {
        if (!burstCheck(user)) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
    }

    private void userLoseLogic(Player dealer, Player user) {
        dealer.getWinningState().plusWinCount();
        user.getWinningState().plusLoseCount();
    }

    private void comparePlayersLogic(Player dealer, Player user) {
        if (dealer.getCardValueSum() > user.getCardValueSum()) {
            dealer.getWinningState().plusWinCount();
            user.getWinningState().plusLoseCount();
        }
        if (dealer.getCardValueSum() < user.getCardValueSum()) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
    }

    private boolean burstCheck(Player player) {
        return player.getCardValueSum() > BlackJackController.BURST_COUNT;
    }
}
