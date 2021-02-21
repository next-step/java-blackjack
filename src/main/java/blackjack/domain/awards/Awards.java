package blackjack.domain.awards;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import java.util.List;

public class Awards {
    public static final int FINISH_BOUND = 21;
    public static final double BLACK_JACK_EARNING_RATE = 1.5;
    public static final double BUST_EARNING_RATE = -1.0;
    public static final double WIN_EARNING_RATE = 1.0;
    public static final double LOSS_EARNING_RATE = -1.0;

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
        if(player.getState().cards().isBlackJack()){
            player.setEarningRate(BLACK_JACK_EARNING_RATE);
            return true;
        }
        if(player.getState().cards().isBust()) {
            player.setEarningRate(BUST_EARNING_RATE);
            return false;
        }
        // 딜러가 버스트 인지 || 블랙잭, 버스트 둘 다 아니라면 합계가 21과 가장 가까운지 확인.
        if(dealer.getCards().getSum()> FINISH_BOUND || player.getState().cards().getSum() > dealer.getCards().getSum()) {
            player.setEarningRate(WIN_EARNING_RATE);
            return true;
        }
        player.setEarningRate(LOSS_EARNING_RATE);
        return false;
    }
}
