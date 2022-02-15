package blackjack.controller;

import blackjack.domain.CardPack;
import blackjack.domain.Dealer;
import blackjack.domain.GamePlayers;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class GameController {

    public void start() {
        CardPack cardPack = CardPack.create();
        Dealer dealer = new Dealer(cardPack);

        GamePlayers gamePlayers = GamePlayers.makePlayers(InputView.getPlayerName());

        dealer.initializeGame(gamePlayers);
        printInitialStatus(gamePlayers);
        dealer.playGame(gamePlayers);

        OutputView.printCardResult(gamePlayers);
        OutputView.printGameResult(gamePlayers);
    }

    private void printInitialStatus(GamePlayers gamePlayers) {
        List<Player> players = gamePlayers.getPlayers();

        OutputView.printInitialMessage(players);

        for (Player player : players) {
            OutputView.printCardStatus(player);
        }
    }
}
