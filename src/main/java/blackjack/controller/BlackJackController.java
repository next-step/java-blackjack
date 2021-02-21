package blackjack.controller;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class BlackJackController {

    private static final int DEALER_ONE_MORE_DRAW = 3;

    private final Gamers gamers;
    private final BlackJackCard blackJackCard;
    private final OutputView outputView;

    public BlackJackController() {
        blackJackCard = BlackJackCard.of();
        outputView = new OutputView();
        gamers = new Gamers();
        registerUser();
    }

    private void registerUser() {
        String[] usersName = InputView.getUsersName();
        gamers.addUsers(getMoneyForEachUser(usersName));
    }

    public void initCardHand() {
        gamers.initGamerCardHand(blackJackCard);
        outputView.outputDealerStatus(gamers.getDealer());
        gamers.getUsers().forEach(outputView::outputPlayerStatus);
    }

    public void decideToDraw() {
        drawPhase(gamers.getDealer());
        if (gamers.getDealer().getCardBundleSize() == DEALER_ONE_MORE_DRAW) {
            outputView.outputDealersDraw();
        }
        for (Player player : gamers.getUsers()) {
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
        return isDraw && player.getCardHandScore() < CardBundle.BLACK_JACK;
    }

    private boolean decideToDrawCard(Player player) {
        boolean isDraw = InputView.getDecision(player.getName());
        if (isDraw) {
            player.drawCard(blackJackCard.pickOneCard());
        }
        outputView.outputPlayerStatus(player);
        return isDraw;
    }

    public void printResultOfCard() {
        for (Player player : gamers.getPlayers()) {
            outputView.outputPlayerScore(player);
        }
    }

    public void winOrLoseOfPlayer() {
        gamers.calculateResult();
        outputView.outputFinalResult(gamers.getPlayers());
    }

    private Map<String,Integer> getMoneyForEachUser(String[] users) {
        Map<String, Integer> nameAndMoneys = new HashMap<>();
        for (String user : users) {
            nameAndMoneys.put(user, InputView.getMoney(user));

        }
        return nameAndMoneys;
    }

    public void printRevenueForEachPlayers() {
        gamers.caculateRevenue();
        outputView.outputFinalRevenue(gamers.getPlayers());
    }
}
