package blackjack.domain.awards;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import java.util.List;

public class Awards {
    public static final int FINISH_BOUND = 21;
    private static AwardsResult awardResult;

    public static AwardsResult produceResult(Dealer dealer, List<Player> players) {
        for(Player player : players) {
            player.setIsWin(comparePlayerDealer(dealer, player));
        }
        dealer.winResult(players);
        awardResult = new AwardsResult(dealer, players);
        return awardResult;
    }

    private static boolean comparePlayerDealer(Dealer dealer, Player player) {
        if(player.getState().cards().isBlackJack()){return true;}
        if(player.getState().cards().isBust()) {return false;}
        if(dealer.getCards().getSum()> FINISH_BOUND) { return true; }
        return player.getState().cards().getSum() > dealer.getCards().getSum(); //블랙잭, 버스트 둘 다 아니라면 합계가 21과 가장 가까운지 확인.
    }
}
