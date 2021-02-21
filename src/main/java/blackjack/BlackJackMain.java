package blackjack;

import blackjack.controller.BlackJackController;

public class BlackJackMain {
    public static void main(String[] args) {
        BlackJackController blackJackController = new BlackJackController();
        blackJackController.initCardHand();
        blackJackController.decideToDraw();
        blackJackController.printResultOfCard();
        blackJackController.winOrLoseOfPlayer();
        blackJackController.printRevenueForEachPlayers();
    }
}