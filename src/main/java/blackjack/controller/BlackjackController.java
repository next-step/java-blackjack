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
                OutputView.printNewLine();
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

    // TODO: 별도 객체로 분리
    public void releaseResult() {
        Dealer dealer = blackjackGame.getDealer();
        OutputView.printGameParticipantResultMessage(dealer);
        List<Player> players = blackjackGame.getPlayers();
        for (Player player : players) {
            OutputView.printGameParticipantResultMessage(player);
        }

        int dealerWin = 0;
        int dealerDraw = 0;
        int dealerLose = 0;
        int dealerScore = dealer.getResult();
        for (Player player : players) {
            int playerScore = player.getResult();
            if (playerScore > 21 || (dealerScore > playerScore && dealerScore <= 21)) {
                dealerWin += 1;
            } else if (dealerScore == playerScore && playerScore != 21) {
                dealerDraw += 1;
            } else {
                dealerLose += 1;
            }
        }
        OutputView.printDealerGameResult(dealerWin, dealerDraw, dealerLose);

        for (Player player : players) {
            String result;
            int playerScore = player.getResult();
            if (playerScore < dealerScore || playerScore > 21) {
                result = "패";
            } else if (playerScore == dealerScore) {
                result = "무";
            } else {
                result = "승";
            }
            OutputView.printPlayerGameResult(player.getName(), result);
        }
    }
}
