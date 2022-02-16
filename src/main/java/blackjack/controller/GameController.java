package blackjack.controller;

import blackjack.Players;
import blackjack.view.InputView;
import java.util.List;

public class GameController {

    public void run() {
        List<String> playerNames = InputView.getNames();
        Players.create(playerNames);
    }
}
