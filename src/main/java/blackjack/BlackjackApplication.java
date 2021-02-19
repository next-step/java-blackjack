package blackjack;

import blackjack.controller.BlackjackController;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackjackApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        BlackjackController blackjackController = new BlackjackController(inputView, resultView);
        blackjackController.gameStart();
    }
}
