package blackjack.controller;

import blackjack.domain.card.CardPack;
import blackjack.domain.gameplayer.GamePlayer;
import blackjack.domain.gameplayer.GamePlayers;
import blackjack.domain.gameplayer.Names;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class GameController {

    public void start() {
        final CardPack cardPack = new CardPack();
        final GamePlayers gamePlayers = new GamePlayers(getConsoleNames());

        initializeGame(gamePlayers, cardPack);
        printInitialStatus(gamePlayers);

        playGame(gamePlayers, cardPack);
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

    public void initializeGame(final GamePlayers gamePlayers, final CardPack cardPack) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        players.forEach(player -> {
            player.receiveCard(cardPack.pick());
            player.receiveCard(cardPack.pick());
        });
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

    public void playGame(GamePlayers gamePlayers, CardPack cardPack) {
        final List<GamePlayer> players = gamePlayers.getPlayers();
        final GamePlayer dealer = gamePlayers.getDealer();

        for (final GamePlayer player : players) {
            playerGameProcess(player, cardPack);
        }
        dealerGameProcess(dealer, cardPack);
    }

    private void playerGameProcess(final GamePlayer player, CardPack cardPack) {
        while (player.isContinue() && InputView.getPlayerChoice(player)) {
            player.receiveCard(cardPack.pick());
            OutputView.printCardStatus(player);
        }

        OutputView.printCardStatus(player);
    }

    private void dealerGameProcess(final GamePlayer dealer, CardPack cardPack) {
        while (dealer.isLowerThanBound()) {
            dealer.receiveCard(cardPack.pick());
            OutputView.printDealerAcceptCard();
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
