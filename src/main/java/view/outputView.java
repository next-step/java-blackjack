package view;

import Domain.Dealer;
import Domain.Participant;
import Domain.Player;
import Domain.TrumpCard;

import java.util.Arrays;
import java.util.List;

public class outputView {
    public static void outputPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void outputPlayerInfo(String[] playerNames) {
        for(int i=0; i<playerNames.length-1; i++) {
            System.out.print(playerNames[i] + ", ");
        }
        System.out.println(playerNames[playerNames.length-1] + " 에게 2장의 나누었습니다.");
    }


    public static void outputParticipantCardInfo(Participant participant) {
        System.out.println(participant.getName() + ": " + participant.getCardName());
    }

    public static void outputMoreCard(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public static void outputDealerCard(){
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public static void outputParticipantResult(Participant participant) {
        System.out.println(participant.getName() + ": " + participant.getCardName() + " - 결과: " + participant.getParticipantScore());
    }

    public static void outputResult(Dealer dealer, List<Player> playerlist){
        System.out.println("\n## 최종 승패");
        System.out.println("딜러: " + dealer.dealerWinCount+"승 " + dealer.dealerLoseCount + "패" );
        playerlist.forEach(player -> System.out.println(player.getName() + ": " + player.playerResult));
    }

    public static void outputBettingResult(Dealer dealer, List<Player> playerlist){
        System.out.println("\n## 최종 수익");
        System.out.println("딜러: " + dealer.winningPrice );
        playerlist.forEach(player -> System.out.println(player.getName() + ": " + player.winningPrice));
    }

    public static void outputBettingPrice(String name) {
        System.out.println(name+"의 배팅 금액은?");
    }
}
