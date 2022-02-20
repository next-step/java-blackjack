package blackjack.controller;

import blackjack.domain.cards.DealerCards;
import blackjack.domain.cards.PlayerCards;
import blackjack.domain.game.GameResult;
import blackjack.domain.person.Dealer;
import blackjack.domain.person.Player;
import blackjack.view.InputView;
import blackjack.view.ResultView;
import java.util.List;

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
        final DealerCards dealerCards = dealer.getDealerCards();
        if (dealerCards.canReceiveMoreCard()) {
            dealerCards.addCard(dealer.getPickedCard());
            ResultView.printDealerReceiveCard();
        }
    }

    private void askPlayers() {
        for (Player player : players) {
            askPlayer(player);
        }
    }

    private void askPlayer(Player player) {
        final PlayerCards playerCards = player.getPlayerCards();
        while (playerCards.canReceiveMoreCard() && InputView.isHit(player)) {
            playerCards.addCard(dealer.getPickedCard());
        }
    }

    private void printGameResult() {
        ResultView.printDealerAndPlayerCardResult(dealer.getDealerCards(), players);
        ResultView.printGameResult(new GameResult(dealer.getDealerCards().getSumOfCards(), players));
    }
}
