package blackjack.domain;


import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.List;

public class Dealer {

    private static final int BLACKJACK = 21;
    private final CardPack cardPack;

    public Dealer(CardPack cardPack) {
        this.cardPack = cardPack;
    }

    public void game(List<Player> players) {
        for (Player player : players) {
            if (player.isDealer()) continue;

            if(isLowerThanBlackJack(player)) {
                OutputView.printQuestionAcceptCard(player);

                while (InputView.getPlayerChoice()) {
                    cardPack.giveCard(player);
                    OutputView.printCardStatus(player);
                }
            }
        }
    }

    public boolean isLowerThanBlackJack(Player player) {
        return player.getScore() < BLACKJACK;
    }
}
