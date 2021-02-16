package blackjack;

import blackjack.controller.BlackjackController;

public class BlackjackApplication {

    public static void main(String[] args) {
        BlackjackController blackjackController = new BlackjackController();
        blackjackController.start();
        blackjackController.askHitOrStayToPlayers();
        blackjackController.dealerTurn();
        blackjackController.releaseResult();
        blackjackController.finalResult();
    }
}
