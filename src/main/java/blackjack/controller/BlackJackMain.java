package blackjack.controller;

import blackjack.service.BlackJackGame;
import blackjack.service.Players;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackJackMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        BlackJackGame blackJackGame = new BlackJackGame();

        Players players = blackJackGame.startGame(inputView.inputPlayerName());
        resultView.resultStartCard(players);
        blackJackGame.addDraw();
        blackJackGame.aceCheck();
        resultView.resultFinalCard(players);
        //blackJackGame.setZero();
        blackJackGame.resultGamer();
        resultView.resultFinal();
        blackJackGame.outputResult();

    }

}
