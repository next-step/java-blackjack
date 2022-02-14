package blackjack.controller;

import blackjack.domain.Player;
import blackjack.view.InputView;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public void start() {
        List<String> playerNames = InputView.getPlayerName();
        List<Player> players = playerNames.stream()
            .map(Player::new)
            .collect(Collectors.toList());
    }
}
