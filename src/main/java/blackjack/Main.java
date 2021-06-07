package blackjack;

import blackjack.controller.BlackJackController;

public class Main {
    public static void main(String[] args) {
        BlackJackController blackJackController = new BlackJackController();

        blackJackController.blankJackStart();
    }
}
