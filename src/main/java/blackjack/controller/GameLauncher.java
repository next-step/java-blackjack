package blackjack.controller;

import blackjack.domain.Card.Dealer;
import blackjack.domain.Card.MatchInfo.MatchResultBoard;
import blackjack.domain.Card.Player;
import blackjack.domain.Card.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

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

        if (dealer.calcScore(dealer) < DEALER_SUM_LIMIT) {
            dealer.addCard(dealer.getCards());
            OutputView.printDealerAddCard();
        }

        OutputView.printDealerCardSum(dealer);
        OutputView.printPlayerCardSum(players);

        OutputView.printFinalGameResult();
        MatchResultBoard matchResultBoard = players.playMatch(dealer);
        OutputView.printDealerMatchResult(dealer, matchResultBoard.getDealerMatchScoreInfo());
        OutputView.printPlayersMatchResult(matchResultBoard.getPlayersMatchScoreInfo());

    }

    private void getCardOrNot(Player player) {
        while (InputView.readAddCardOrNot(player) && player.calcScore(player) < BLACK_JACK_SUM_LIMIT) {
            player.addCard(player.getCards());
            OutputView.printPlayerStatus(player);
        }
    }
}
