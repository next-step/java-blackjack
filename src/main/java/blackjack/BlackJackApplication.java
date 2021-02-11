package blackjack;

import blackjack.controller.MainController;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackApplication {
    public static void main(String[] args) {
        MainController mainController = new MainController(
            new InputView(),
            new OutputView()
        );

        mainController.playGame();
    }
}
