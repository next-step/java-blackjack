package blackjack.service;

import blackjack.view.ResultView;

import java.util.List;

public class Dealer extends Player {

    ResultView resultView = new ResultView();
    List<Result> resultList;

    Dealer() {
        name = "딜러";
    }

    @Override
    void addDraw(CardDeck cardDeck) {
        for (; ; ) {
            int score = getScore(); //(x,y)->x+y
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

}
