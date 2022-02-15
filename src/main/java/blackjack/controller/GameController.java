package blackjack.controller;

import blackjack.domain.CardPack;
import blackjack.domain.Dealer;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {

    public void start() {
        CardPack cardPack = CardPack.create();
        Dealer dealer = new Dealer(cardPack);

        List<Player> players = makePlayers();

        cardPack.pickCard(players);

        OutputView.printInitialMessage(players);

        for (Player player : players) {
            OutputView.printCardStatus(player);
        }

        dealer.game(players);
    }

    private List<Player> makePlayers() {
        List<String> playerNames = InputView.getPlayerName();

        Player dealerPlayer = new Player("딜러", true);

        List<Player> dealerPlayers = Arrays.asList(dealerPlayer);

        List<Player> commonPlayers = playerNames.stream()
            .map(player -> new Player(player, false))
            .collect(Collectors.toList());

        return Stream.of(dealerPlayers, commonPlayers)
            .flatMap(lotto -> lotto.stream())
            .collect(Collectors.toList());
    }
}
