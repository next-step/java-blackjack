package blackjack.view;

import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.Card;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.PlayingCard;

import java.util.List;

public class OutputView {

    public static void inputPlayerNames() {
        System.out.println("플레이어 이름 입력");
    }

    public static void messageAfterInit(List<Player> players) {
        System.out.printf("딜러와 ");
        for(Player player : players){
            System.out.printf("%s, ",player.getName());
        }
        System.out.println("에게 2장의 카드를 나눴습니다.");
    }

    public static void cardStateAfterInit(Dealer dealer, List<Player> players) {

        // 딜러의 1장의 카드 출력.(다른 한 장은 뒤집어 진 상태)
        System.out.printf("딜러 : ");
        Card dealerCard = dealer.getCards().getCards().get(0);
        System.out.printf("%s_%d\n",dealerCard.getSuit(),dealerCard.getDenomination().getScore());

        // 플레이어의 2장의 카드 출력.
        for(Player player : players) {
            System.out.printf("%s 카드 : ",player.getName());
            List<PlayingCard> playingCards = player.getState().cards().getCards();
            for(PlayingCard card : playingCards){
                System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
            }
            System.out.println();
        }
    }

    public static void cardStateAfterEnd(Dealer dealer, List<Player> players) {
        System.out.printf("딜러 카드 : ");
        for(PlayingCard card : dealer.getCards().getCards()){
            System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
        }
        System.out.printf("합계 : %d\n",dealer.getCards().getSum());

        // OutputView
        for(Player player : players) {
            List<PlayingCard> playingCards = player.getState().cards().getCards();
            System.out.printf("%s 카드 : ",player.getName());
            for(PlayingCard card : playingCards){
                System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
            }
            System.out.printf(" - 결과 : %d\n",player.getState().cards().getSum());
        }
    }

    public static void award(AwardsResult awardsResult) {
        System.out.printf("딜러의 결과 : %d 승 %d 패\n", awardsResult.getDealer().getWinCount(),awardsResult.getDealer().getLossCount());
        for(Player player : awardsResult.getPlayers()){
            System.out.printf("%s : ",player.getName());
            if(player.getIsWin()){
                System.out.println(" 승");
            }
            else{
                System.out.println(" 패");
            }
        }
    }
}
