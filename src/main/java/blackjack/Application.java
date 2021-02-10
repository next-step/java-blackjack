package blackjack;

import blackjack.controller.BlackjackController;
import blackjack.model.Players;
import blackjack.view.InputView;

public class Application {
    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final BlackjackController blackjackController = new BlackjackController(inputView);
        final Players players = blackjackController.inputGamerNames();
    }
}