package blackjack.domain;


import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class Dealer {

    private static final int INITIAL_CARD_QUANTITY = 2;
    private final CardPack cardPack;

    public Dealer(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public void initializeGame(GamePlayers gamePlayers) {
        List<GamePlayer> players = gamePlayers.getAllPlayers();

        for (int i = 0; i < INITIAL_CARD_QUANTITY; i++) {
            players.stream()
                .forEach(player -> giveCardAfterPick(player));
        }
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
            giveCardAfterPick(player);
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
            giveCardAfterPick(dealer);
            System.out.println(dealer.getScore());
        }
    }

    private void giveCardAfterPick(GamePlayer player) {
        player.receiveCard(cardPack.remove());
    }
}
