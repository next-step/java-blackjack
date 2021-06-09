package blackjack.model;

import blackjack.view.InputView;
import blackjack.view.ResultView;

public class Gamer extends Player {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    Result result;

    Gamer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void addDraw(CardDeck cardDeck) {
        for (; ; ) {
            if (sumScore() <= 21) {
                String result = inputView.inputAddCard(name);
                if (result.equals("y")) {
                    draw(cardDeck);
                    resultView.resultPlayer(this);
                } else {
                    break;
                }
            } else {
                System.out.println("더 이상 카드를 추가하실수 없습니다.");
                break;
            }
        }

    }

    @Override
    void result(int dealerScore) {
        if (score < dealerScore || score > 21) {
            result = Result.lose;
        } else if (score > dealerScore) {
            result = Result.win;
        } else if (score == dealerScore) {
            result = Result.draw;
        }
    }

    @Override
    public boolean isGamer() {
        return true;
    }

    @Override
    void outputResult() {
        System.out.println(this.getName() + ": " + result.getMarkResult());
    }

    public Result getResult() {
        return result;
    }
}
