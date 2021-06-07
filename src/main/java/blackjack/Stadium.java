package blackjack;

import java.util.List;
import java.util.Scanner;

public class Stadium {
    List<Gambler> gamblers;

    public Stadium(List<Gambler> gamblers) {
        this.gamblers = gamblers;
    }

    // 카드 게임 한 번
    public List<Gambler> playCardGame() {
        for (Gambler gambler : gamblers) {
            gambler.drawCard();
        }
        return gamblers;
    }

    public boolean selectChoice(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine() == "y") {
            return true;
        }
        return false;
    }

}
