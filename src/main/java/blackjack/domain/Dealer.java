package blackjack.domain;

import blackjack.domain.card.CardPack;
import blackjack.domain.gameplayer.GamePlayer;
import blackjack.domain.gameplayer.GamePlayers;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class Dealer {

    private final CardPack cardPack;

    public Dealer(final CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public void initializeGame(final GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        players.forEach(player -> {
            player.receiveCard(cardPack.pick());
            player.receiveCard(cardPack.pick());
        });
    }

    public void playGame(GamePlayers gamePlayers) {
        final List<GamePlayer> players = gamePlayers.getPlayers();
        final GamePlayer dealer = gamePlayers.getDealer();

        for (final GamePlayer player : players) {
            playerGameProcess(player);
        }
        dealerGameProcess(dealer);
    }

    private void playerGameProcess(final GamePlayer player) {
        while (player.isContinue() && InputView.getPlayerChoice(player)) {
            player.receiveCard(cardPack.pick());
            OutputView.printCardStatus(player);
        }

        OutputView.printCardStatus(player);
    }

    private void dealerGameProcess(final GamePlayer dealer) {
        while (dealer.isLowerThanBound()) {
            OutputView.printDealerAcceptCard();
            dealer.receiveCard(cardPack.pick());
        }
    }
}
