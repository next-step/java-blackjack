package blackjack.controller;

import blackjack.service.BlackJackGame;
import blackjack.service.Player;
import blackjack.view.InputView;
import blackjack.view.ResultView;

import java.util.List;

public class BlackJackMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        BlackJackGame blackJackGame = new BlackJackGame();

        List<Player> players = blackJackGame.getPlayer(inputView.inputPlayerName());
        resultView.resultStartCard(blackJackGame.startDraw());
        blackJackGame.addDraw();
        blackJackGame.aceCheck();
        resultView.resultFinalCard(players);
        blackJackGame.setZero();
        blackJackGame.resultGamer();
        resultView.resultFinal();
        blackJackGame.outputResult();

    }

}
