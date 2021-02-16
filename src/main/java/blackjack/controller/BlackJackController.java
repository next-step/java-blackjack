package blackjack.controller;

import blackjack.model.card.BlackJackCard;
import blackjack.model.player.Gamers;
import blackjack.model.player.Player;
import blackjack.model.player.User;
import blackjack.model.player.Dealer;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackController {
    private final Gamers gamers;
    private final BlackJackCard blackJackCard;

    public BlackJackController() {
        blackJackCard = BlackJackCard.of();
        gamers = new Gamers();
        registerUser();
    }

    private void registerUser() {
        String[] usersName = InputView.getUsersName();
        gamers.addUsers(usersName);
    }

    public void initCardHand() {
        gamers.initGamerCardHand(blackJackCard);
        gamers.getPlayers().forEach(OutputView::outputPlayerStatus);
    }

    public void decideToDraw() {
        for (Player player : gamers.getPlayers()) {
            drawPhase(blackJackCard, player);
        }
    }

    private void drawPhase(BlackJackCard blackJackCard, Player player) {
        if (player instanceof User) {
            decideToDrawCard(blackJackCard, player);
            OutputView.outputPlayerStatus(player);
            return;
        }

        if (player.getCardHand().calculateScore() <= Dealer.UPPER_BOUND_TO_DRAW) {
            player.drawCard(blackJackCard.pickOneCard());
            OutputView.outputDealersDraw();
        }
    }

    private void decideToDrawCard(BlackJackCard blackJackCard, Player player) {
        boolean isDraw = InputView.getDecision(player.getName());
        if (isDraw) {
            player.drawCard(blackJackCard.pickOneCard());
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
