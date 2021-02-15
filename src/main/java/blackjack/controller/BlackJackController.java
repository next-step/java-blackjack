package blackjack.controller;

import blackjack.model.BlackJackCard;
import blackjack.model.Gamers;
import blackjack.model.Player;
import blackjack.model.User;
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
        gamers.getPlayers().forEach(player -> OutputView.outputPlayerStatus(player));
    }

    public void decideToDraw() {
        for (Player player : gamers.getPlayers()) {
            drawPhase(blackJackCard, player);
        }
    }

    private static void drawPhase(BlackJackCard blackJackCard, Player player) {
        if (player instanceof User) {
            decideToDrawCard(blackJackCard, player);
            OutputView.outputPlayerStatus(player);
            return;
        }
        player.drawCard(blackJackCard.pickOneCard());
        OutputView.outputDealersDraw();
    }
    private static void decideToDrawCard(BlackJackCard blackJackCard, Player player) {
        boolean isDraw = InputView.getDecision(player.getName());
        if(isDraw) {
            player.drawCard(blackJackCard.pickOneCard());
        }
    }

    public void printResultOfCard(){
        for (Player player : gamers.getPlayers()) {
            OutputView.outputPlayerScore(player);
        }
    }

    public void winOrLoseOfPlayer(){
        gamers.calculateResult();
        OutputView.outputFinalResult(gamers.getPlayers());
    }
}
