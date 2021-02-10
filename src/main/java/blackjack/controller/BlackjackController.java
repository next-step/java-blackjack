package blackjack.controller;

import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackjackController {
    InputView inputView;
    ResultView resultView;

    BlackjackController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void joinPlayers() {
        inputView.getGamers();

    }
}
