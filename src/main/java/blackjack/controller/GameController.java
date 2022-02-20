package blackjack.controller;

import blackjack.domain.BlackJackGame;
import blackjack.domain.card.CardPack;
import blackjack.domain.gameplayer.GamePlayers;
import blackjack.domain.gameplayer.Name;
import blackjack.domain.gameplayer.Names;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public void start() {
        final CardPack cardPack = CardPack.create();
        final BlackJackGame dealer = new BlackJackGame(cardPack);
        final GamePlayers gamePlayers = GamePlayers.makePlayers(getConsoleNames());

        dealer.initializeGame(gamePlayers);
        printInitialStatus(gamePlayers);

        dealer.playGame(gamePlayers);
        printFinalStatus(gamePlayers);
    }

    private Names getConsoleNames() {
        try {
            return convertStringsToNames(InputView.getPlayerName());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getConsoleNames();
        }
    }

    private Names convertStringsToNames(List<String> originNames) {
        return new Names(originNames.stream()
            .map(Name::new)
            .collect(Collectors.toList()));
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
