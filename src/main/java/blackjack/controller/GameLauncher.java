package blackjack.controller;

import blackjack.domain.gamer.Dealer;
import blackjack.domain.gamer.Gamer;
import blackjack.domain.matchInfo.MatchResultBoard;
import blackjack.domain.gamer.Player;
import blackjack.domain.gamer.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GameLauncher {

    private static final int BLACK_JACK_SUM_LIMIT = 21;

    public void start() {
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

        if (dealer.getCardOrNot(dealer)) {
            OutputView.printDealerAddCard();
        }

        OutputView.printDealerCardSum(dealer);
        OutputView.printPlayerCardSum(players);

        OutputView.printFinalGameResult();
        MatchResultBoard matchResultBoard = players.playMatch(dealer);
        OutputView.printDealerMatchResult(dealer, matchResultBoard.getDealerMatchResultInfo());
        OutputView.printPlayersMatchResult(matchResultBoard.getPlayersMatchResultInfo());

    }

    private void getCardOrNot(Gamer player) {
        while (InputView.readAddCardOrNot(player) && player.calcScore(player) < BLACK_JACK_SUM_LIMIT) {
            player.addCard(player.getCards());
            OutputView.printPlayerStatus(player);
        }
    }
}
