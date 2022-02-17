package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.ResultView;
import java.util.Objects;

public class BlackJackController {

    public static void playBlackJack() {
        Deck deck = Deck.createDeck();
        Dealer dealer = new Dealer();
        Players players = Players.createPlayers(InputView.getPlayers());

        ResultView resultView = new ResultView(dealer, players);
        resultView.inputPlayersPrint();

        dealer.initOwnCards(deck);
        players.getPlayers().forEach(player -> player.initOwnCards(deck));

        resultView.playerCardsPrint(dealer);
        players.getPlayers().forEach(resultView::playerCardsPrint);

        players.getPlayers().forEach(player -> {
            while (player.isAvailDraw() && Objects.equals(InputView.doQuestion(player), "y")) {
                player.drawOneCards(deck);
                resultView.playerCardsPrint(player);
            }
        });

        if (dealer.isAvailDraw()) {
            dealer.drawOneCards(deck);
            resultView.dealerDrawCardPrint(dealer);
        }
    }
}
