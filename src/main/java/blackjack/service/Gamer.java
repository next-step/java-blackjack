package blackjack.service;

import blackjack.view.InputView;
import blackjack.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Gamer extends Player {


    InputView inputView =new InputView();
    ResultView resultView =new ResultView();
    Gamer(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    void addDraw(CardDeck cardDeck) {
        for(;;) {
            String a = inputView.inputAddCard(name);

            if (a.equals("y")) {
                draw(cardDeck);
                resultView.resultCard(this);
            } else {
                break;
            }
        }


    }
}
