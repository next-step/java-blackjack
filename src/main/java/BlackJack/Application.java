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
        System.out.println(NEWLINE + "딜러와 " + names + "에게 2장의 나누었습니다.");
    }
}
