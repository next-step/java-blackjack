package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class MainController {
    private final InputView input;
    private final OutputView output;

    public MainController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void playGame() {
        PhaseController phaseController = new PhaseController(
            Players.create(input.inputPlayersName()),
            new Dealer(),
            Deck.createRandomDeck()
        );

        phaseController.actionStandByPhase(output);
        phaseController.actionMainPhase(input, output);
        phaseController.actionEndPhase(output);
    }
}
