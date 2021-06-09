package blackjack.service;

import blackjack.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
            if (sumScore() <= 16) {
                draw(cardDeck);
                resultView.resultDealer();
            } else {
                break;
            }
        }
    }

    @Override
    void result(int gamerScore) {
        if (score < gamerScore || score > 21) {
            resultList.add(Result.lose);
        } else if (score > gamerScore) {
            resultList.add(Result.win);
        } else if (score == gamerScore) {
            resultList.add(Result.draw);
        }
    }

    @Override
    public boolean isGamer() {
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

    public List<Result> getResultList() {
        return resultList;
    }
}
