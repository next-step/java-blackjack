package blackjack;

import blackjack.controller.BlackJackController;

public class BlackJackApplication {

    public static void main(String[] args) {
        BlackJackController gameManager = new BlackJackController();
        gameManager.play();
    }
}
