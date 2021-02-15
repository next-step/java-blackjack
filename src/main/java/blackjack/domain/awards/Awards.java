package blackjack.domain.awards;

import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import java.util.List;

public class Awards {
    private static AwardsResult awardResult;

    public static AwardsResult produceResult(Dealer dealer, List<Player> players) {
        for(Player player : players) {
            player.setIsWin(comparePlayerDealer(dealer, player));
        }
        dealer.winResult(players);

        awardResult = new AwardsResult(dealer, players);
        return awardResult; // 클래스를 만들어 줘야 할까? 이 친구는 딜러, 플레이어들 객체를 다 받아 결과를 낸 후 하나의 List로 묶어 준다.
    }

    private static boolean comparePlayerDealer(Dealer dealer, Player player) {
        if(player.getState().cards().isBlackJack()){return true;}
        if(player.getState().cards().isBust()) {return false;}
        if(dealer.getCards().getSum()>21) { return true; }
        return player.getState().cards().getSum() > dealer.getCards().getSum(); //블랙잭, 버스트 둘 다 아니라면 합계가 21과 가장 가까운지 확인.
    }
}
