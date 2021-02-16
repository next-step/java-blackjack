package blackjack.controller;

import blackjack.domain.awards.Awards;
import blackjack.domain.awards.AwardsResult;
import blackjack.domain.player.Dealer;
import blackjack.domain.player.Player;
import blackjack.domain.state.Hit;
import blackjack.domain.state.State;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJackController {

    private List<Player> players;
    private Dealer dealer;

    public void play() {
        initGame();
        playEachPlayerGame();
        printDealerStatus();
        OutputView.printGameResult(dealer, players);
        printAwardsResult();
    }

    private void initGame() {
        // create Dealer and init dealer card
        dealer = new Dealer();
        dealer.initDealerCard();
        // get player names and parse it into player objects
        String rawPlayerNames = InputView.inputPlayerNames();
        players = createPlayers(splitPlayerNames(rawPlayerNames));
        OutputView.printGameInitInfo(dealer, players);
    }

    private List<String> splitPlayerNames(String rawPlayerNames) {
        List<String> playerNames = Arrays.asList(rawPlayerNames.split(","));
        playerNames = playerNames.stream().map(raw -> raw.trim()).collect(Collectors.toList());
        return playerNames;
    }

    private List<Player> createPlayers(List<String> playerNames) {
        players = playerNames.stream()
            .map(playerName -> new Player(playerName, new Hit(dealer.initCard())))
            .collect(Collectors.toList());
        return players;
    }

    private void playEachPlayerGame() {
        players.forEach(this::playLoop);
    }

    private void playLoop(Player player) {
        State state = player.getState();
        while (!state.isFinished()) {
            String answer = InputView.inputGetCardOrNot(player.getName());
            if ("y".equals(answer)) {
                state = state.draw(dealer.popAndGiveCard());
                OutputView.printPlayerCards(player);
            }
            if ("n".equals(answer)) {
                state = state.stay();
            }
        }
    }

    private void printDealerStatus() {
        if (dealer.getCards().checkDealerCardCondition()) {
            dealer.addDealerCard();
            OutputView.printDealerStatusUnder(dealer.getName());
            return;
        }
        OutputView.printDealerStatusOver(dealer.getName());
    }

    private void printAwardsResult() {
        AwardsResult awardsResult = Awards.produceResult(dealer, players);
        OutputView.printGameAwards(awardsResult);
    }
}
