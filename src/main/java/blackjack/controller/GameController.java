package blackjack.controller;

import blackjack.domain.CardPack;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    public void start() {
        List<String> playerNames = InputView.getPlayerName();
        List<Player> players = playerNames.stream()
            .map(Player::new)
            .collect(Collectors.toList());

        Dealer dealer = new Dealer(0, new ArrayList<>());

        CardPack cardPack = CardPack.create();
        cardPack.removeCard(players);
        cardPack.removeCard(dealer);

        OutputView.printInitialMessage(players);

        for (Player player : players) {
            OutputView.printCardStatus(player);
        }
    }
}
