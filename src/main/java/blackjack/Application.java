package blackjack;

import blackjack.controller.BlackjackController;
import blackjack.model.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final BlackjackController blackjackController = new BlackjackController(inputView, outputView);
        final Players players = blackjackController.inputGamerNames();

        blackjackController.prepareGame(players);
        blackjackController.hitGamer(players);
        blackjackController.hitDealer(players);
        blackjackController.standGame(players);
    }
}