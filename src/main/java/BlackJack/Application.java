package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String NEWLINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String inputName = in.nextLine();
        List<String> names = Arrays.asList(inputName.split(","));
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        Dealer dealer = new Dealer();
        PlayGame playGame = new PlayGame(players, dealer);
        playGame.gameStart(2);
        System.out.println(NEWLINE + dealer.getDEALER_NAME() + "와 " + names + "에게 2장 나누었습니다.");
        System.out.print(dealer.getDEALER_NAME() + " : ");
        Output.showCardStatus(dealer.getHoldingCards());
        for (Player player : players) {
            System.out.print(player.getPlayerName() + " : ");
            Output.showCardStatus(player.getHoldingCards());
        }
        System.out.println();
        for (Player player : players) {
            isQuestion(player, playGame);
        }
        System.out.println();
        while(dealer.isDrawCard(dealer.sumCards())) {
            System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
            playGame.drawCardDealer();
        }
        System.out.print(dealer.getDEALER_NAME() + " : ");
        Output.showCardStatus2(dealer.getHoldingCards(), dealer.sumCards());
        for (Player player : players) {
            System.out.print(player.getPlayerName() + " : ");
            Output.showCardStatus2(player.getHoldingCards(), player.sumCards());
        }
        System.out.println();
        WinnerResult winnerResult = new WinnerResult(players, dealer);
        winnerResult.countWinLoseDealer();
        System.out.println(dealer.getDEALER_NAME() + ": " + winnerResult.getWinCount() + "승 " + winnerResult.getLoseCount() + "패");
        for (Player player : players) {
            System.out.println(player.getPlayerName() + ": " + winnerResult.findWinnerPlayer().get(player.getPlayerName()));
        }
    }

    private static void isQuestion(Player player, PlayGame playGame) {
        Scanner in = new Scanner(System.in);
        boolean agree = true;
        while(player.isDrawCard(player.sumCards()) && agree) {
            System.out.println(player.getPlayerName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
            String agreement = in.nextLine();
            agree = isDraw(agreement,player,playGame);
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
}
