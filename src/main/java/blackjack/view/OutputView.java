package blackjack.view;

import blackjack.domain.awards.AwardsResult;
import blackjack.domain.card.Card;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.PlayingCard;

import java.util.List;

import static blackjack.view.ViewConstantStrings.*;

public class OutputView {

    public static void inputPlayerNames() {
        System.out.println(INPUT_PLAYER_NAMES.toString());
    }

    public static void messageAfterInit(List<Player> players) {
        System.out.printf(DEALER_AND.toString());
        for(Player player : players){
            System.out.printf("%s, ",player.getName());
        }
        System.out.println(GIVE_TWO_CARDS.toString());
    }

    public static void cardStateAfterInit(Dealer dealer, List<Player> players) {

        // 딜러의 1장의 카드 출력.(다른 한 장은 뒤집어 진 상태)
        System.out.printf(DEALER.toString());
        Card dealerCard = dealer.getCards().getCards().get(0);
        System.out.printf("%s_%d\n",dealerCard.getSuit(),dealerCard.getDenomination().getScore());

        // 플레이어의 2장의 카드 출력.
        for(Player player : players) {
            System.out.printf("%s %s",player.getName(), CARD.toString());
            List<PlayingCard> playingCards = player.getState().cards().getCards();
            for(PlayingCard card : playingCards){
                System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
            }
            System.out.println();
        }
    }

    public static void cardStateAfterEnd(Dealer dealer, List<Player> players) {
        System.out.printf(DEALER_CARD.toString());
        for(PlayingCard card : dealer.getCards().getCards()){
            System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
        }
        System.out.printf("%s %d %s",SUM.toString(),dealer.getCards().getSum(),NEW_LINE.toString());

        // OutputView
        for(Player player : players) {
            List<PlayingCard> playingCards = player.getState().cards().getCards();
            System.out.printf("%s %s",player.getName(),CARD.toString());
            for(PlayingCard card : playingCards){
                System.out.printf("%s_%d, ",card.getSuit(),card.getDenomination().getScore());
            }
            System.out.printf("%s %d %s",RESULT.toString(),player.getState().cards().getSum(),NEW_LINE.toString());
        }
    }

    public static void award(AwardsResult awardsResult) {
        System.out.printf("%s%d %s %d %s%s",DEALER_RESULT.toString(), awardsResult.getDealer().getWinCount(),WIN.toString(), awardsResult.getDealer().getLossCount(),LOSS.toString(), NEW_LINE.toString());
        for(Player player : awardsResult.getPlayers()){
            System.out.printf("%s %s",player.getName(), COLON.toString());
            if(player.getIsWin()){
                System.out.println(WIN.toString());
            }
            else{
                System.out.println(LOSS.toString());
            }
        }
    }
}
