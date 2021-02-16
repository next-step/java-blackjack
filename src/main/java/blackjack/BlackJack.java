package blackjack;

import blackjack.controller.BlackJackController;

public class BlackJack {

    public static void main(String[] args) {
        BlackJackController blackJackController = new BlackJackController();
        blackJackController.startGame();
    }
}
