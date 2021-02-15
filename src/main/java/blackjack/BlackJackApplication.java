package blackjack;

import blackjack.controller.CasinoController;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackJackApplication {
    public static void main(String[] args) {
        CasinoController casinoController = new CasinoController(
            new InputView(),
            new OutputView()
        );

        casinoController.playGame();
    }
}
