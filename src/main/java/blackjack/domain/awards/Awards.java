package blackjack.domain.awards;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Blackjack;
import blackjack.domain.state.Bust;
import java.util.List;

public class Awards {
    private static int BLACKJACK = 21;
    private static AwardsResult awardResult;

    public static AwardsResult produceResult(Dealer dealer, List<Player> players) {
        players.forEach(player -> player.setIsWin(comparePlayerDealer(dealer, player)));
        dealer.winResult(players);
        awardResult = new AwardsResult(dealer, players);
        return awardResult;
    }

    private static boolean comparePlayerDealer(Dealer dealer, Player player) {
        int dealerScore = dealer.getCards().sumScore();
        int playerScore = player.getState().cards().sumScore();
        if(playerScore == BLACKJACK
            || (playerScore <= BLACKJACK && dealerScore > BLACKJACK)
            || (playerScore <= BLACKJACK && dealerScore <= BLACKJACK && playerScore > dealerScore)) {
            return true;
        }
        return false;
    }
}
