package blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Gambler {
    private String name;
    private List<Card> cards;

    public Gambler() {
        this("dealer");
    }

    public Gambler(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public void drawCard() {
        List<Card> cardList = Cards.getCards();
        Collections.shuffle(cardList);
        this.cards.add(cardList.remove(0));
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean selectChoice(String name) {
        System.out.println(name + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("y")) {
            return true;
        }
        return false;
    }
}
