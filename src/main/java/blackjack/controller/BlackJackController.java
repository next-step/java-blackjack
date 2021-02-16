package blackjack.controller;

import blackjack.model.card.BlackJackCard;
import blackjack.model.player.Gamers;
import blackjack.model.player.Player;
import blackjack.model.player.User;
import blackjack.model.player.Dealer;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

public class BlackJackController {
    private final Gamers gamers;
    private final BlackJackCard blackJackCard;

    public BlackJackController() {
        blackJackCard = BlackJackCard.of();
        gamers = new Gamers();
        registerUser();
    }

    private void registerUser() {
        List<String> usersName = InputView.getUsersName();
        gamers.addUsers(usersName);
    }

    public void initCardHand() {
        gamers.initGamerCardHand(blackJackCard);
        gamers.getPlayers().forEach(OutputView::outputPlayerStatus);
    }

    public void decideToDraw() {
        for(User user: gamers.getUsers()) {
            userDrawPhase(user);
        }
        dealerDrawPhase(gamers.getDealer());
    }

    private void userDrawPhase(User user) {
        while(InputView.getDecision(user.getName())){
            user.drawCard(blackJackCard.pickOneCard());
        }
        OutputView.outputPlayerStatus(user);
    }

    private void dealerDrawPhase(Dealer dealer) {
        if (dealer.getCardHand().calculateScore() <= Dealer.UPPER_BOUND_TO_DRAW) {
            dealer.drawCard(blackJackCard.pickOneCard());
            OutputView.outputDealersDraw();
        }
    }

    public void printResultOfCard() {
        for (Player player : gamers.getPlayers()) {
            OutputView.outputPlayerScore(player);
        }
    }

    public void winOrLoseOfPlayer() {
        gamers.calculateResult();
        OutputView.outputFinalResult(gamers.getPlayers());
    }
}
