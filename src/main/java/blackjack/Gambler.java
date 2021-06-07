package blackjack;

import java.util.List;
import java.util.Scanner;

public class Gambler {
    private String name;
    private String card;

    public Gambler() {
        this("dealer", "확인용");
    }

    public Gambler(String name) {
        this(name, "확인용");
    }

    public Gambler(String name, String card) {
        this.name = name;
        this.card = card;
    }

    public void drawCard() {
        card += " " + new Card().getCard();
    }

    public String getName() {
        return name;
    }

    public String getCard() {
        return card;
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
