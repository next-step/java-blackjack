package blackjack.controller;

import blackjack.domain.CardDeck;
import blackjack.domain.Dealer;
import blackjack.domain.Game;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.dto.PlayerDTO;
import blackjack.dto.FinalScoreDTO;
import blackjack.view.InputView;
import blackjack.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BlackJackController {

    public BlackJackController() {
    }

    public void run() {
        List<String> playerNames = InputView.inputPlayerNames();
        CardDeck deck = new CardDeck();
        Dealer dealer = Dealer.create();
        Players players = new Players(playerNames);

        Game game = new Game(dealer, players, deck);
        game.init();

        printResultOfDeal(dealer, players, playerNames);

        playerTurn(deck, players);
        dealerTurn(deck, dealer);

        printFinalResult(dealer, players);
        printWinOrLose(game);
    }


    private void printResultOfDeal(Dealer dealer, Players players, List<String> playerNames) {
        List<PlayerDTO> results = new ArrayList<>();
        results.add(PlayerDTO.from(dealer));
        for (Player player : players.get()) {
            results.add(PlayerDTO.from(player));
        }

        OutputView.printCards(String.join(", ", playerNames), results);
    }

    private void playerTurn(CardDeck deck,Players players) {
        for (Player player : players.get()) {
            askMoreCard(deck, player);
        }
    }

    private void askMoreCard(CardDeck deck,Player player) {
        while (!player.isBusted()) {
            boolean answer = InputView.askHitOrStand(player.getName());
            if (!answer) break;

            player.hit(deck);
            OutputView.printCard(PlayerDTO.from(player));
        }
    }

    private void dealerTurn(CardDeck deck, Dealer dealer) {
        while (dealer.checkHitOrNot()) {
            dealer.hit(deck);
            OutputView.printDealerHit();
        }
    }

    private void printFinalResult(Dealer dealer, Players players) {
        List<FinalScoreDTO> results = new ArrayList<>();
        results.add(FinalScoreDTO.from(dealer));
        for (Player player : players.get()) {
            results.add(FinalScoreDTO.from(player));
        }

        OutputView.printGameResults(results);
    }

    private void printWinOrLose(Game game) {
        game.mapResults();
        OutputView.printWinOrLose(game);
    }

}
