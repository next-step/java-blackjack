package blackjack.controller;

import blackjack.service.BlackJackGame;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackJackMain {

    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    static BlackJackGame blackJackGame = new BlackJackGame();

    public static void main(String[] args) {
       blackJackGame.getPlayer(inputView.inputPlayerName());
       resultView.resultStartCard(blackJackGame.startDraw());


    }

}
