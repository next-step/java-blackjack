package blackjack;

import java.util.List;
import java.util.Scanner;

public class Gambler {
    private String name;
    private List<Card> card;

    public Gambler() {
        this("dealer", null);
    }

    public Gambler(String name) {
        this(name, null);
    }

    public Gambler(String name, List<Card> card) {
        this.name = name;
        this.card = card;
    }

    public void drawCard() {
        card.add(new Card());
    }

    public String getName() {
        return name;
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
