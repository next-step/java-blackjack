package blackjack.controller;


import blackjack.domain.Card.Dealer;
import blackjack.domain.Card.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameLauncher {

    public void start() {
        OutputView.requestPlayersName();
        String[] playerNames = InputView.readPlayerName();
        OutputView.printGamePlayer(playerNames);

        OutputView.printCardsSetting(playerNames);

        Dealer dealer = new Dealer();
        OutputView.printDealerCardsSetting(dealer);

        Players players = new Players(playerNames);
        OutputView.printPlayerStatus(players);
    }
}

