package blackjack;

import blackjack.controller.BlackJack;
import blackjack.domain.request.UserNamesRequest;
import blackjack.view.InputView;

public class BlackjackApplication {

    public static void main(String[] args) {
        String playerNames = InputView.getPlayerNames();
        BlackJack blackJack = BlackJack.init(UserNamesRequest.from(playerNames));
        blackJack.runGame();
    }
}
