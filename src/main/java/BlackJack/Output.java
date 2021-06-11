package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Output {

    private static final String NEWLINE = System.getProperty("line.separator");

    public static void showPlayerName() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void showGameStart(Dealer dealer, List<Player> players, List<String> names) {
        System.out.println(NEWLINE + dealer.getDEALER_NAME() + "와 " + String.join(", ", names) + "에게 2장 나누었습니다.");
        System.out.print(dealer.getDEALER_NAME() + " : ");
        Output.showCardStatus(dealer.getHoldingCards());
        for (Player player : players) {
            System.out.print(player.getPlayerName() + " : ");
            Output.showCardStatus(player.getHoldingCards());
        }
        System.out.println();
    }

    public static void isQuestion(Player player, PlayGame playGame) {

        boolean agree = true;
        while (player.isDrawCard(player.sumCards()) && agree) {
            System.out.println(player.getPlayerName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
            agree = isDraw(Input.agreement(), player, playGame);
        }
        System.out.println();

    }

    public static void giveDealerCard(Dealer dealer, PlayGame playGame) {
        while (dealer.isDrawCard(dealer.sumCards())) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
            playGame.drawCardDealer();
        }
        System.out.println();
        System.out.print(dealer.getDEALER_NAME() + " : ");
    }

    public static void isDrawPlayer(List<Player> players) {
        for (Player player : players) {
            System.out.print(player.getPlayerName() + " : ");
            Output.showCardStatus2(player.getHoldingCards(), player.sumCards());
        }
        System.out.println();
    }

    public static void showWinOrLose(Dealer dealer, List<Player> players) {
        System.out.println(dealer.getDEALER_NAME() + ": " + dealer.getWinCount() + "승 " + dealer.getLoseCount() + "패");
        for (Player player : players) {
            System.out.println(player.getPlayerName() + ": " + player.getPlayerResult());
        }
    }

    private static boolean isDraw(String agreement, Player player, PlayGame playGame) {
        Scanner in = new Scanner(System.in);
        if (agreement.equals("y")) {
            playGame.drawCardPlayer(player);
            System.out.print(player.getPlayerName() + " : ");
            Output.showCardStatus(player.getHoldingCards());
            return true;
        }
        return false;
    }

    private static List<String> makeCardStatus(List<Card> holdingCards) {
        List<String> cardStatus = new ArrayList<>();
        int holdingCardsSize = holdingCards.size();
        for (int i = 0; i < holdingCardsSize; i++) {
            cardStatus.add(holdingCards.get(i).getCardNumber().getOutputScore() + holdingCards.get(i).getCardShape());
        }
        return cardStatus;
    }

    public static void showCardStatus(List<Card> holdingCards) {
        System.out.println(String.join(", ", makeCardStatus(holdingCards)));
    }

    public static void showCardStatus2(List<Card> holdingCards, int sumCards) {
        System.out.println(String.join(", ", makeCardStatus(holdingCards)) + "- 결과: " + sumCards);
    }

}
