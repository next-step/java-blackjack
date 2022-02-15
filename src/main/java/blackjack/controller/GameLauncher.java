package blackjack.controller;

import blackjack.domain.Card.Dealer;
import blackjack.domain.Card.GameResult;
import blackjack.domain.Card.Player;
import blackjack.domain.Card.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class GameLauncher {
    private static final int DEALER_SUM_LIMIT = 16;
    private static final int BLACK_JACK_SUM_LIMIT = 21;

    public void start() {
        OutputView.requestPlayersName();
        String[] playerNames = InputView.readPlayerName();
        OutputView.printGamePlayer(playerNames);

        OutputView.printCardsSetting(playerNames);

        Dealer dealer = new Dealer();
        OutputView.printDealerCardsSetting(dealer, true);

        Players players = new Players(playerNames);
        OutputView.printPlayersStatus(players);

        for (Player player : players.getPlayers()) {
            getCardOrNot(player);
        }

        if (dealer.getPlayerCardSum(dealer) < DEALER_SUM_LIMIT) {
            dealer.addCard(dealer.getCards());
            OutputView.printDealerAddCard();
        }

        OutputView.printDealerCardSum(dealer);
        OutputView.printPlayerCardSum(players);

        OutputView.printFinalGameResult();
        GameResult gameResult = new GameResult(players, dealer);
        List<Integer> gameResultList = gameResult.getGameResult();
        OutputView.printGameResult(gameResultList, players);
    }

    private void getCardOrNot(Player player) {
        while (InputView.readAddCardOrNot(player) && player.getPlayerCardSum(player) < BLACK_JACK_SUM_LIMIT) {
            player.addCard(player.getCards());
            OutputView.printPlayerStatus(player);
        }
    }

}


