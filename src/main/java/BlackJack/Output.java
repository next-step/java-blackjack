package BlackJack;

import BlackJack.actor.Dealer;
import BlackJack.actor.Player;
import BlackJack.actor.Players;
import BlackJack.card.Card;
import BlackJack.game.PlayGame;
import BlackJack.game.Result;

import java.util.ArrayList;
import java.util.List;

public class Output {

    private static final String NEWLINE = System.getProperty("line.separator");

    public static void showPlayerName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void showGameStart(Dealer dealer, Players players, List<String> names) {
        System.out.println(NEWLINE + dealer.getDEALER_NAME() + "와 " + String.join(", ", names) + "에게 2장 나누었습니다.");
        System.out.print(dealer.getDEALER_NAME() + " : ");
        System.out.println(String.join(", ", makeCardStatus(dealer.getHoldingCards())));
        players.getPlayers().forEach(player ->
                System.out.println(player.getPlayerName() + ": " +
                        String.join(", ", makeCardStatus(player.getHoldingCards()))));
        System.out.println();
    }

    public static void isQuestion(Player player, PlayGame playGame) {
        System.out.println(player.getPlayerName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public static void space() {
        System.out.println();
    }

    public static void giveDealerCard(Dealer dealer) {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
        System.out.println();
    }

    public static void isDrawPlayer(Players players) {
        players.getPlayers().forEach(player -> {
            System.out.print(player.getPlayerName() + " : ");
            Output.showCardStatus2(player.getHoldingCards(), player.sumCards());
        });
        System.out.println();
    }

    public static void showCardStatus(List<Card> holdingCards) {
        System.out.println(String.join(", ", makeCardStatus(holdingCards)));
    }

    public static void showCardStatus2(List<Card> holdingCards, int sumCards) {
        System.out.println(String.join(", ", makeCardStatus(holdingCards)) + "- 결과: " + sumCards);
    }

    private static List<String> makeCardStatus(List<Card> holdingCards) {
        List<String> cardStatus = new ArrayList<>();
        int holdingCardsSize = holdingCards.size();
        for (int i = 0; i < holdingCardsSize; i++) {
            cardStatus.add(holdingCards.get(i).getCardNumber().getOutputScore() + holdingCards.get(i).getCardShape());
        }
        return cardStatus;
    }

    public static void showDealerWinOrLose(Result result, Dealer dealer) {
        System.out.println(dealer.getDEALER_NAME() + " : " + result.getWinResult().get(dealer.getDEALER_NAME()) + " 승 " +  result.getLoseResult().get(dealer.getDEALER_NAME()) + "패");
    }

    public static void showPlayerWinOrLose(Result result, Player player) {
        System.out.println(player.getPlayerName()+" : " + result.getWinResult().get(player.getPlayerName())+ " 승 " +
                result.getLoseResult().get(player.getPlayerName()) + "패");

    }
}
