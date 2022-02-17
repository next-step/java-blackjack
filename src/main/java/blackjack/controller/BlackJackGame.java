package blackjack.controller;

import blackjack.domain.game.GameResult;
import blackjack.domain.person.Dealer;
import blackjack.domain.person.Player;
import blackjack.view.InputView;
import blackjack.view.ResultView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackJackGame {

    private final Dealer dealer;
    private final List<Player> players;

    public BlackJackGame() {
        dealer = new Dealer();
        players = Player.createPlayers(InputView.getPlayerNames(), dealer);
        ResultView.printSetUpResult(dealer.getOpenedCard(), players);
    }

    public void play() {
        askPlayers();
        giveDealerCard();
        printGameResult();
    }

    private void giveDealerCard() {
        if (dealer.canGetCard()) {
            dealer.addCard(dealer.getPickedCard());
            ResultView.printDealerReceiveCard();
        }
    }

    private void askPlayers() {
        for (Player player : players) {
            askPlayer(player);
        }
    }

    private void askPlayer(Player player) {
        while (player.canHit() && InputView.isHit(player)) {
            player.addCard(dealer.getPickedCard());
        }
    }

    private void printGameResult() {
        ResultView.printDealerAndPlayerCardResult(dealer, players);
        ResultView.printGameResult(getGameResult());
    }

    private GameResult getGameResult() {
        Map<String, String> playerResult = new HashMap<>();
        int dealerWin = 0;
        int dealerSum = dealer.getSumOfCards();

        for (Player player : players) {
            if (player.getSumOfCards() < dealerSum) {
                dealerWin++;
                playerResult.put(player.getName(), "패");
                continue;
            }
            playerResult.put(player.getName(), "승");
        }

        return new GameResult(playerResult, dealerWin, players.size() - dealerWin);
    }
}
