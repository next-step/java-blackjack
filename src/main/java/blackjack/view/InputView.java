package blackjack.view;

import blackjack.Dealer;
import blackjack.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public List<String> insertPlayer() {
        System.out.println("게임의 참여할 사람의 입력하세요.(쉼표 기준으로 분리)");
        return Arrays.stream(sc.nextLine()
                .replace(" ", "")
                .split(",")).toList();
    }

    public void init(Dealer dealer, List<Player> players) {
        List<String> names = players.stream().map(Player::getName).toList();
        String text = String.join(", ", names);
        System.out.println("딜러와 " + text + "에게 2장의 카드를 나누었습니다.");
        System.out.println("딜러:" + dealer.toStringList(1));
        players.forEach(player -> {
           printCards(player);
        });
    }

    public void printCards(Player player) {
        System.out.println(player.getName() + "카드: " + player.toStringList());
    }

    public boolean isProvide(String name) {
        System.out.println(name + "은(는) 한장의 카드를 더 받으시겠습니까? (예는 y, 아니오는 n)");
        String yn = sc.nextLine();
        if("y".equals(yn.toLowerCase())) {
            return true;
        }
        return false;
    }
}
