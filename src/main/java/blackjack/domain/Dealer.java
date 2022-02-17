package blackjack.domain;


import blackjack.domain.card.CardPack;
import blackjack.domain.gameplayer.GamePlayer;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class Dealer {

    private final CardPack cardPack;

    public Dealer(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public void initializeGame(GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        players.forEach(player -> {
            player.receiveCard(cardPack.remove());
            player.receiveCard(cardPack.remove());
        });

        for (GamePlayer gamePlayer : players) {
            System.out.println(gamePlayer.getName() + ", "+ gamePlayer.getScore());
        }
    }

    public void playGame(final List<GamePlayer> players, final GamePlayer dealer) {
        for (final GamePlayer player : players) {
            playerGameProcess(player);
        }
        dealerGameProcess(dealer);
    }

    private void playerGameProcess(final GamePlayer player) {
        while (player.isContinue() && InputView.getPlayerChoice(player)) {
            player.receiveCard(cardPack.remove());
            OutputView.printCardStatus(player);
        }
        if (!player.isContinue()) {
            // 탈락
        }
        OutputView.printCardStatus(player);
    }

    private void dealerGameProcess(final GamePlayer dealer) {
        while (dealer.isLowerThanBound()) {
            OutputView.printDealerAcceptCard();
            dealer.receiveCard(cardPack.remove());
            System.out.println(dealer.getScore());
        }
    }
}
