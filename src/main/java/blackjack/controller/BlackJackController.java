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
            drawPhase(player);
        }
    }

    private void drawPhase(Player player) {
        if (player instanceof User) {
            drawRepeatedly(player);
            return;
        }

        if (player.getCardHand().calculateScore() <= Dealer.UPPER_BOUND_TO_DRAW){
            player.drawCard(blackJackCard.pickOneCard());
        }
    }

    private void drawRepeatedly(Player player) {
        boolean isDraw;
        do {
            isDraw = decideToDrawCard(player);
        } while (isDrawable(isDraw, player));
    }

    private boolean isDrawable(boolean isDraw, Player player) {
        return isDraw && player.getCardHandScore() < 21;
    }

    private boolean decideToDrawCard(Player player) {
        boolean isDraw = InputView.getDecision(player.getName());
        if (isDraw) {
            player.drawCard(blackJackCard.pickOneCard());
        }
        OutputView.outputPlayerStatus(player);
        return isDraw;
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
