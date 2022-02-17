package blackjack.view;

import blackjack.domain.person.Player;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> getPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)");
        String[] playerNames = sc.nextLine().split(",");
        return Arrays.stream(playerNames).collect(Collectors.toList());
    }

    public static boolean isHit(Player player) {
        System.out.println(player.getName() + "는 한 장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
        return sc.nextLine().equals("y");
    }
}
