package blackjack.controller;

import blackjack.domain.CardPack;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {

    public void start() {
        List<String> playerNames = InputView.getPlayerName();

        Player dealerPlayer = new Player("딜러", true);

        List<Player> dealerPlayers = Arrays.asList(dealerPlayer);

        List<Player> commonPlayers = playerNames.stream()
            .map(player -> new Player(player, false))
            .collect(Collectors.toList());

        List<Player> players = Stream.of(dealerPlayers, commonPlayers)
            .flatMap(lotto -> lotto.stream())
            .collect(Collectors.toList());

        CardPack cardPack = CardPack.create();
        cardPack.removeCard(players);

        OutputView.printInitialMessage(players);

        for (Player player : players) {
            OutputView.printCardStatus(player);
        }
    }
}
