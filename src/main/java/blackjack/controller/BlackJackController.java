package blackjack.controller;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.HashMap;
import java.util.Map;

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
        gamers.addUsers(getMoneyForEachUser(usersName));
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

        if (player.getCardHand().calculateScore() <= Dealer.UPPER_BOUND_TO_DRAW){
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

    private Map<String,Integer> getMoneyForEachUser(String[] users) {
        Map<String, Integer> nameAndMoneys = new HashMap<>();
        for (String user : users) {
            nameAndMoneys.put(user, InputView.getMoney(user));

        }
        return nameAndMoneys;
    }
}
