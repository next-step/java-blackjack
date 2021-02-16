package blackjack.domain.awards;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Blackjack;
import blackjack.domain.state.Bust;
import java.util.List;

public class Awards {
    private static int BLACKJACK_SCORE = 21;
    private static AwardsResult awardResult;

    public static AwardsResult produceResult(Dealer dealer, List<Player> players) {
        players.forEach(player -> player.setIsWin(comparePlayerDealer(dealer, player)));
        dealer.winResult(players);
        awardResult = new AwardsResult(dealer, players);
        return awardResult; // 클래스를 만들어 줘야 할까? 이 친구는 딜러, 플레이어들 객체를 다 받아 결과를 낸 후 하나의 List로 묶어 준다.
    }

    private static boolean comparePlayerDealer(Dealer dealer, Player player) {
        int dealerScore = dealer.getCards().sumScore();
        int playerScore = player.getState().cards().sumScore();
        if(player.getState() instanceof Blackjack
            || (!(player.getState() instanceof Bust)
            && Math.abs(dealerScore - BLACKJACK_SCORE) > Math.abs(playerScore - BLACKJACK_SCORE))) {
            return true;
        }
        return false;
    }
}
