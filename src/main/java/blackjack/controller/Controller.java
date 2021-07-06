package blackjack.controller;

import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start() {
        String names = inputView.inputName();
        Dealer dealer = new Dealer();
        List<Player> players = createPlayers(names);

        dealer.initialCardSetting();
        for (Player player : players) {
            player.initialCardSetting();
        }
        outputView.printInitialCardSetting(dealer, players);

        for (Player player : players) {
            boolean additionalCard = false;
            while (inputView.inputAdditionalCard(player)) {
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
//        Stadium stadium = new Stadium(participants);
//        stadium.playCardGame();
    }

    private List<Player> createPlayers(String names) {
        List<Player> players = new ArrayList<>();
        for (String name : names.split(",")) {
            players.add(new Player(name));
        }
        return players;
    }
}
