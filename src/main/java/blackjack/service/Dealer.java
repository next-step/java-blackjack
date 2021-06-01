package blackjack.service;

import blackjack.view.ResultView;

public class Dealer extends Player {


    ResultView resultView = new ResultView();
    Dealer() {
        name = "딜러";
    }

    @Override
    void addDraw(CardDeck cardDeck) {
        int score = getScore(); //(x,y)->x+y
        if (score <= 16) {
            draw(cardDeck);
            resultView.resultDealer();
        }

    }


}
