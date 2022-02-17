package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Judgement;
import blackjack.domain.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackGame {

    private static final int THRESHOLD = 21;

    public void play() {
        List<String> playersName = getPlayerName();
        Dealer dealer = new Dealer();
        List<Player> players = playersName.stream().map(Player::new)
            .collect(Collectors.toList());

        List<Player> allGamblers = getAllGamblers(dealer, players);
        allGamblers.forEach(dealer::allocateInitialCards);
        OutputView.printPlayersCard(allGamblers);

        betting(dealer, players);

        checkIfDealerGotMoreCard(dealer);

        Judgement judgement = new Judgement(allGamblers);
        OutputView.printGameResult(allGamblers, judgement.findWinners());
    }

    private void betting(Dealer dealer, List<Player> players) {
        List<Player> alivePlayers = players;
        boolean isPlaying;
        do {
            isPlaying = isAnyOneGettingMoreCard(dealer, alivePlayers);
            alivePlayers = filterBustedPlayer(alivePlayers);
        }
        while (isPlaying);
    }

    private List<Player> filterBustedPlayer(List<Player> alive) {
        return alive.stream().filter(player -> player.calculateScore() <= THRESHOLD)
            .collect(Collectors.toList());
    }

    private boolean isAnyOneGettingMoreCard(Dealer dealer, List<Player> players) {
        boolean isPlaying = false;
        for (Player player : players) {
            isPlaying = isPlayerGettingMoreCard(dealer, player);
        }
        return isPlaying;
    }

    private boolean isPlayerGettingMoreCard(Dealer dealer, Player player) {
        boolean answer = InputView.askAddCard(player);
        if (answer) {
            dealer.allocateCard(player);
            OutputView.printJoinedCardInfo(player);
            OutputView.printNextLine();
            return true;
        }
        return false;
    }

    private List<String> getPlayerName() {
        List<String> playersName = InputView.getPlayersName();
        OutputView.printInitialCardDistribute(playersName);
        return playersName;
    }

    private void checkIfDealerGotMoreCard(Dealer dealer) {
        if (dealer.addOneMoreCard()) {
            OutputView.printDealerReceived();
        }
    }

    private List<Player> getAllGamblers(Dealer dealer, List<Player> players) {
        List<Player> allGamblers = new ArrayList<>();
        allGamblers.add(dealer);
        allGamblers.addAll(players);
        return allGamblers;
    }


}
