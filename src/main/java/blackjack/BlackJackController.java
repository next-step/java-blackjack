package blackjack;

import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;
import java.util.stream.Stream;

public class BlackJackController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        final List<String> names = inputView.insertPlayer();
        List<Player> players = names.stream()
                .map(name -> new Player(name))
                .toList();

        Dealer dealer = new Dealer();

        //init
        dealer.deal(dealer);
        dealer.deal(dealer);
        for(Player player : players) {
            dealer.deal(player);
            dealer.deal(player);
        }
        inputView.init(dealer, players);
        for(Player player : players) {
            while (inputView.isProvide(player.getName())) {
                dealer.deal(player);
                inputView.printCards(player);
            }
        }
        while (outputView.isProvide(dealer)) {
            dealer.deal(dealer);
        }
        outputView.printTotalScore(dealer, players);
        final Table table = new Table(players, dealer);
        outputView.printResult(table);
    }
}
