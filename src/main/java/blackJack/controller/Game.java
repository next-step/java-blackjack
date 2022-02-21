package blackJack.controller;

import blackJack.domain.BlackJack;
import blackJack.domain.Player;
import blackJack.domain.UserStats;
import blackJack.util.Util;
import blackJack.view.InputView;
import blackJack.view.OutputView;
import java.util.List;

public class Game {

    private static Game game = null;
    private final BlackJack blackJack;

    private Game(List<String> playerNames) {
        blackJack = BlackJack.from(playerNames);
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game(getPlayerName());
        }
        return game;
    }

    public void run() {
        init();
        goPhase();
        summarize();
    }

    private void init() {
        blackJack.initCardDraw();
        OutputView.printInitCardDrawFormat(blackJack.getGameUser().convertPlayersName());
        OutputView.printUserStatus(blackJack.getGameUser());
    }

    private void goPhase() {
        playerPhase();
        dealerPhase();
    }

    private void playerPhase() {
        for (Player player : blackJack.getGamePlayers()) {
            useTurn(player);
        }
    }

    private void useTurn(Player player) {
        while (player.isCardDraw()) {
            OutputView.printRequestAdditionalCardDrawFormat(player);
            if (InputView.readYN()) {
                player.appendToDeck(blackJack.drawGameCard());
                OutputView.printPlayerStatus(player);
                continue;
            }
            OutputView.printPlayerStatus(player);
            break;
        }
    }

    private void dealerPhase() {
        if (blackJack.getGameDealer().isCardDraw()) {
            blackJack.getGameDealer().additionalCardDraw(blackJack.drawGameCard());
            OutputView.printDealerAdditionalCardDraw();
        }
    }

    private void summarize() {
        UserStats userStats = UserStats.of(blackJack.getGameUser());
        OutputView.printTotalScore(userStats.convertTotalScore());
        OutputView.printTotalResult(userStats.convertTotalResult());
    }

    private static List<String> getPlayerName() {
        OutputView.printRequestPlayerNames();
        return Util.stringToStringList(InputView.readPlayerName());
    }
}
