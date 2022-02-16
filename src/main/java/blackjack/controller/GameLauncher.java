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
        // ace가 포함되어있으면 11을 더해서 21아래면 11로 해주고 아니면 1을 해준다.
        for (Player player : players.getPlayers()) {
            getCardOrNot(player);
        }

        if (dealer.getPlayerCardSum(dealer) < DEALER_SUM_LIMIT) { // ace 10 11
            dealer.addCard(dealer.getCards());
            OutputView.printDealerAddCard();
        }

        OutputView.printDealerCardSum(dealer);
        OutputView.printPlayerCardSum(players);

        // TODO 21이 다넘을 때
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


