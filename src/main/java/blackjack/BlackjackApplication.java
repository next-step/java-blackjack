package blackjack;

import blackjack.controller.BlackJack;
import blackjack.view.InputView;
import java.util.List;

public class BlackjackApplication {

    public static void main(String[] args) {
        List<String> playerNames = InputView.getPlayerNames();
        BlackJack blackJack = BlackJack.init(playerNames);
        blackJack.runGame();
    }
}
