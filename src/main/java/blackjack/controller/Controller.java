package blackjack.controller;

import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.model.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        String names = inputView.inputName();
        Dealer dealer = new Dealer();
        Players players = createPlayers(names);

        dealer.initialCardSetting();
        players.initialCardSetting();

        outputView.printInitialCardSetting(dealer, players.getPlayers());

        for (Player player : players.getPlayers()) {
            boolean additionalCard = false;
            while (player.score() < 21 && inputView.inputAdditionalCard(player)) {
                player.additionalCardSetting();
                outputView.printAdditionalPlayerCards(player);
                additionalCard = true;
            }
            if (!additionalCard) {
                outputView.printAdditionalPlayerCards(player);
            }
        }
        if (dealer.score() < 16) {
            dealer.additionalCardSetting();
            outputView.printAdditionalDealerCards();
        }

        outputView.printResult(dealer, players.getPlayers());

        int maxScore = players.findMaxScore();
        outputView.printWinOrLose(dealer, players.getPlayers(), maxScore);
    }

    private Players createPlayers(String names) {
        List<Player> players = new ArrayList<>();
        for (String name : names.split(",")) {
            players.add(new Player(name));
        }
        return new Players(players);
    }
}
