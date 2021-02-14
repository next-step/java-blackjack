package blackjack.controller;

import blackjack.model.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {
    final private InputView inputView;
    final private OutputView outputView;

    public BlackjackController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Players inputGamerNames() {
        return inputView.inputGamerNames();
    }

    public void play(Players players) {
        final ScenarioController scenarioController = new ScenarioController(players);

        final String prepareGameResult = scenarioController.prepareGame();
        outputView.printResult(prepareGameResult);

        final String startGameResult = scenarioController.startGame(inputView, outputView);
        outputView.printResult(startGameResult);

        final String endGameResult = scenarioController.endGame();
        outputView.gameScore(endGameResult);
    }
}
