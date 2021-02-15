package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class CasinoController {
    private final InputView input;
    private final OutputView output;

    public CasinoController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void playGame() {
        PeopleController peopleController = new PeopleController(Players.create(input.inputPlayersItem()), new Dealer());
        Deck deck = Deck.createRandomDeck();

        peopleController.actionStandByPhase(output, deck);
        peopleController.actionMainPhase(input, output, deck);
        peopleController.actionEndPhase(output);
    }
}
