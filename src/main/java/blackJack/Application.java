package blackJack;

import blackJack.controller.Game;

public class Application {

    public static void main(String[] args) {
        Game game = Game.getInstance();
        game.run();
    }
}
