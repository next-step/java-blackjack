package blackjack.controller;

import blackjack.domain.BlackJackGame;
import blackjack.domain.card.CardPack;
import blackjack.domain.gameplayer.GamePlayer;
import blackjack.domain.gameplayer.GamePlayers;
import blackjack.domain.gameplayer.Names;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class GameController {

    private static final int initialCardSize = 2;

    public void start() {
        final CardPack cardPack = new CardPack();
        final BlackJackGame dealer = new BlackJackGame(cardPack);
        final GamePlayers gamePlayers = new GamePlayers(getConsoleNames());

        dealer.initializeGame(gamePlayers);
        printInitialStatus(gamePlayers);

        dealer.playGame(gamePlayers);
//        printPlayerMessage(gamePlayers);
        printDealerMessage(gamePlayers);
        printFinalStatus(gamePlayers);
    }

    private Names getConsoleNames() {
        try {
            return convertStringToNames(InputView.getPlayerName());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getConsoleNames();
        }
    }

    private Names convertStringToNames(String names) {
        return new Names(names);
    }
    private void printInitialStatus(GamePlayers gamePlayers) {
        printInitialMessage(gamePlayers);
        printCardAllStatus(gamePlayers);
    }

    private void printInitialMessage(GamePlayers gamePlayers) {
        OutputView.printInitialMessage(gamePlayers);
    }

    private void printCardAllStatus(GamePlayers gamePlayers) {
        OutputView.printCardAllStatus(gamePlayers);
    }

    private void printDealerMessage(GamePlayers gamePlayers) {
        GamePlayer dealer = gamePlayers.getDealer();
        int dealerReceiveCount = dealer.getCards().size() - initialCardSize;
        OutputView.printDealerAcceptCard(dealerReceiveCount);
    }

    private void printPlayerMessage(GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getPlayers();
        for (GamePlayer player : players) {
//            OutputView.printCardStatus(player);
        }
    }

    private void printFinalStatus(GamePlayers gamePlayers) {
        printCardResult(gamePlayers);
        printGameResult(gamePlayers);
    }

    private void printCardResult(GamePlayers gamePlayers) {
        OutputView.printCardResult(gamePlayers);
    }

    private void printGameResult(GamePlayers gamePlayers) {
        OutputView.printGameResult(gamePlayers);
    }
}
