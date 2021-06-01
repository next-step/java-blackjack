package blackjack.controller;

import blackjack.service.BlackJackGame;
import blackjack.service.Player;
import blackjack.view.InputView;
import blackjack.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class BlackJackMain {

    static InputView inputView = new InputView();
    static ResultView resultView = new ResultView();

    static BlackJackGame blackJackGame = new BlackJackGame();

    public static void main(String[] args) {
        blackJackGame.getPlayer(inputView.inputPlayerName());

        resultView.resultStartCard(blackJackGame.startDraw());
        blackJackGame.addDraw();

    }

}
