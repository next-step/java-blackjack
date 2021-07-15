package blackjack.model;

import blackjack.controller.BlackJackController;

import java.util.HashMap;
import java.util.Map;

public class WinningLogic {
    private WinningState dealerWinningState;
    private WinningState userWinningState;

    public WinningLogic(){
        this.dealerWinningState = new WinningState();
    }

    public void makeUsersWinningState(Player dealer, Player user) {
        this.userWinningState = new WinningState();
        if (isDealerBurst(dealer)) {
            dealerLoseLogic(user);
            return;
        }

        if (isUserBurst(user)) {
            userLoseLogic();
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

    private void dealerLoseLogic(Player user) {
        if (!burstCheck(user)) {
            dealerWinningState.plusLoseCount();
            userWinningState.plusWinCount();
        }
    }

    private void userLoseLogic() {
        dealerWinningState.plusWinCount();
        userWinningState.plusLoseCount();
    }

    private void comparePlayersLogic(Player dealer, Player user) {
        if (dealer.getCardValueSum() > user.getCardValueSum()) {
            dealerWinningState.plusWinCount();
            userWinningState.plusLoseCount();
        }
        if (dealer.getCardValueSum() < user.getCardValueSum()) {
            dealerWinningState.plusLoseCount();
            userWinningState.plusWinCount();
        }
    }

    private boolean burstCheck(Player player) {
        return player.getCardValueSum() > BlackJackController.BURST_COUNT;
    }

    public String makeDealerResult(){
        return String.valueOf(GameResult.makeDealerResult(dealerWinningState));
    }

    public String makeUserResult(){
        return String.valueOf(GameResult.makeUserResult(userWinningState));
    }

}
