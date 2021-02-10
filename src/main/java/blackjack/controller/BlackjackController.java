package blackjack.controller;

import blackjack.domain.BlackjackGame;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

public class BlackjackController {
    private BlackjackGame blackjackGame;

    public void start() {
        List<Player> players = InputView.getPlayers();
        blackjackGame = new BlackjackGame(players);
        blackjackGame.initializeDeal();
        OutputView.printNewLine();
        printGameParticipantsCards();
    }

    private void printGameParticipantsCards() {
        Dealer dealer = blackjackGame.getDealer();
        List<Player> players = blackjackGame.getPlayers();

        OutputView.printInitializeDealMessage(dealer, players);
        OutputView.beforePrintCards(dealer);
        for (Player player : players) {
            OutputView.beforePrintCards(player);
        }
        OutputView.printNewLine();
    }

    public void askMoreCardToPlayers() {
        List<Player> players = blackjackGame.getPlayers();
        for (final Player player : players) {
            while (player.getResult() < 22 && InputView.askMoreCard(player)) {
                blackjackGame.giveCard(player);
                OutputView.printCards(player);
            }
        }
        OutputView.printNewLine();
    }

    public void dealerTurn() {
        Dealer dealer = blackjackGame.getDealer();
        if (dealer.isActive()) {
            OutputView.printDealerAddCardMessage();
            blackjackGame.giveCard(dealer);
        }
    }
}
