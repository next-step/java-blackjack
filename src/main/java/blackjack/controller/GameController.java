package blackjack.controller;

import blackjack.domain.card.CardPack;
import blackjack.domain.Dealer;
import blackjack.domain.gameplayer.GamePlayers;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameController {

    public void start() {
        final CardPack cardPack = CardPack.create();
        final Dealer dealer = new Dealer(cardPack);
        final GamePlayers gamePlayers = new GamePlayers(InputView.getPlayerName());

        dealer.initializeGame(gamePlayers);
        printInitialStatus(gamePlayers);

        dealer.playGame(gamePlayers);
        printFinalStatus(gamePlayers);
    }

    private void printInitialStatus(GamePlayers gamePlayers) {
        OutputView.printInitialMessage(gamePlayers);
        OutputView.printCardAllStatus(gamePlayers);
    }

    private void printFinalStatus(GamePlayers gamePlayers) {
        OutputView.printCardResult(gamePlayers);
        OutputView.printGameResult(gamePlayers);
    }
}
