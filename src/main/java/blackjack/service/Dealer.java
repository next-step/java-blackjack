package blackjack.service;

import blackjack.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;

public class Dealer extends Player {

    ResultView resultView = new ResultView();
    List<Result> resultList = new ArrayList<>();

    Dealer() {
        name = "딜러";
    }

    @Override
    void addDraw(CardDeck cardDeck) {
        for (; ; ) {
            int score = sumScore(); //(x,y)->x+y
            if (score <= 16) {
                draw(cardDeck);
                resultView.resultDealer();

            } else {
                break;
            }
        }

    }

    @Override
    void result(int gamerScore) {
        if (score > gamerScore) {
            resultList.add(Result.win);
        } else if (score == gamerScore) {
            resultList.add(Result.draw);
        } else {
            resultList.add(Result.lose);
        }
    }

    @Override
    boolean isGamer() {
        return false;
    }

    @Override
    void outputResult() {

        Map<Result, Long> map = resultList.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.print(name + ": ");
        map.forEach((key, value) -> System.out.print(value + "" + key.getMarkResult() + " "));
        System.out.println();
    }

}
