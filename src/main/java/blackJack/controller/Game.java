package blackJack.controller;

import blackJack.domain.BlackJack;
import blackJack.domain.UserStats;
import blackJack.util.Util;
import blackJack.view.InputView;
import blackJack.view.OutputView;
import java.util.List;

public class Game {

    private static Game game = null;

    private Game() {
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void run() {
        List<String> playerNames = getPlayerName();
        BlackJack blackJack = BlackJack.from(playerNames);

        blackJack.initCardDraw();
        OutputView.printInitCardDrawFormat(playerNames);
        OutputView.printUserStatus(blackJack.getGameUser());

        blackJack.playerPhase();
        blackJack.dealerPhase();

        UserStats userStats = UserStats.of(blackJack.getGameUser());

        OutputView.printTotalScore(userStats.convertTotalScore());
    }

    private List<String> getPlayerName() {
        OutputView.printRequestPlayerNames();
        return Util.stringToStringList(InputView.readPlayerName());
    }
}
