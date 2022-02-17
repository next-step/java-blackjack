package blackjack.controller;

import blackjack.domain.card.CardPack;
import blackjack.domain.Dealer;
import blackjack.domain.gameplayer.GamePlayers;
import blackjack.domain.gameplayer.GamePlayer;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class GameController {

    public void start() {
        final CardPack cardPack = new CardPack();

        Dealer dealer = new Dealer(cardPack);

        final GamePlayers gamePlayers = new GamePlayers(InputView.getPlayerName());

        dealer.initializeGame(gamePlayers);
        printInitialStatus(gamePlayers);

        dealer.playGame(gamePlayers.getPlayers(), gamePlayers.getDealer());

        OutputView.printCardResult(gamePlayers);
        OutputView.printGameResult(gamePlayers);
    }

    private void printInitialStatus(GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        OutputView.printInitialMessage(players);

        for (GamePlayer player : players) {
            OutputView.printCardStatus(player);
        }
    }
}
