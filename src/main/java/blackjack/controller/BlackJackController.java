package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackJackController {

    public static void playBlackJack() {
        Deck deck = Deck.createDeck();
        Dealer dealer = new Dealer();
        Players players = Players.createPlayers(InputView.getPlayers());

        ResultView resultView = new ResultView(dealer, players);
        resultView.inputPlayersPrint();
    }
}
