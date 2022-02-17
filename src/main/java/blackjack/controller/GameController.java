package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.view.InputView;

public class GameController {

    public void run() {
        final PeopleController peopleController = new PeopleController(
            Players.create(InputView.getNames()), new Dealer());

        final Deck deck = Deck.create();

        peopleController.setUpPerson(deck);
        peopleController.play(deck);
        peopleController.showGameResult();
    }

}
