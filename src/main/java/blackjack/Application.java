package blackjack;


import blackjack.controller.GameLauncher;

public class Application {

    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher();
        gameLauncher.start();
    }

}
