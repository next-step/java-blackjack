package blackjack.controller;

import blackjack.domain.Card.Dealer;
import blackjack.domain.Card.Player;
import blackjack.domain.Card.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameLauncher {

    private static final int BLACK_JACK_SUM_LIMIT = 21;

    public void start() {
        OutputView.requestPlayersName();
        String[] playerNames = InputView.readPlayerName();
        OutputView.printGamePlayer(playerNames);

        OutputView.printCardsSetting(playerNames);

        Dealer dealer = new Dealer();
        OutputView.printDealerCardsSetting(dealer);

        Players players = new Players(playerNames);
        OutputView.printPlayersStatus(players);

        for (Player player : players.getPlayers()) {
            getCardOrNot(player);
        }

    }

    private void getCardOrNot(Player player) {
        while (InputView.readAddCardOrNot(player) && player.getPlayerCardSum(player) < BLACK_JACK_SUM_LIMIT) {
            player.addCard(player.getCards());
            OutputView.printPlayerStatus(player);

        }
    }

}


