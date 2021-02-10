package blackjack.controller;

import blackjack.model.Players;
import blackjack.view.InputView;

public class BlackjackController {
    final private InputView inputView;

    public BlackjackController(final InputView inputView) {
        this.inputView = inputView;
    }

    public Players inputGamerNames() {
        return inputView.inputGamerNames();
    }
}
