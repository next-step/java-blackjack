package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    private String card;

    public Card() {
        this.card = firstNumber() + secondString();
    }

    private String firstNumber() {
        List<String> firstNumber = new ArrayList<>();
        for (int i = 2; i < 10; i++) {
            firstNumber.add(Integer.toString(i));
        }
        firstNumber.add("A");
        firstNumber.add("K");
        firstNumber.add("Q");
        firstNumber.add("J");

        Collections.shuffle(firstNumber);
        return firstNumber.get(0);
    }

    private String secondString() {
        List<String> secondString = new ArrayList<>();
        secondString.add("스페이드");
        secondString.add("하트");
        secondString.add("클로버");
        secondString.add("다이아");

        Collections.shuffle(secondString);
        return secondString.get(0);
    }
}
