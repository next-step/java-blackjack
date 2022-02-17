package blackjack;

import blackjack.game.GameSetup;
import blackjack.view.InputView;
import blackjack.view.ResultView;
import java.util.List;

public class BlackjackApplication {

    public static void main(String[] args) {
        List<String> playerNames = InputView.getPlayerNames();
        GameSetup gameSetup = new GameSetup(playerNames);
        ResultView.printSetUpResult(gameSetup.getDealer().getOpenedCard(), gameSetup.getPlayers());

    }
}
