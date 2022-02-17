package blackjack.controller;

import blackjack.domain.card.CardPack;
import blackjack.domain.Dealer;
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
        final Dealer dealer = new Dealer(cardPack);
        final GamePlayers gamePlayers = new GamePlayers(getConsoleNames());

        dealer.initializeGame(gamePlayers);
        printInitialStatus(gamePlayers);

        dealer.playGame(gamePlayers);
        printFinalStatus(gamePlayers);
    }

    private Names getConsoleNames() {
        return convertStringsToNames(InputView.getPlayerName());
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
