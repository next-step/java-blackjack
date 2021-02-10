package blackjack;

import blackjack.controller.Controller;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackApplication {
    public static void main(String[] args) {
        Controller controller = new Controller(
            new InputView(),
            new OutputView()
        );

        controller.playGame();
    }
}
