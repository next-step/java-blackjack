package blackjack.controller;

import blackjack.domain.card.CardDeck;
import blackjack.domain.Game;
import blackjack.domain.state.Gameable;
import blackjack.domain.player.Player;
import blackjack.domain.state.State;
import blackjack.domain.Winner;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Controller {

    public void run() {
        Game game = new Game(InputView.inputPlayers());

        initGame(game);
        playGame(game);
        finishGame(game);
    }

    private static void initGame(Game game) {
        OutputView.printStartMessage(game);
        OutputView.printDealerCard(game.getDealer());
        OutputView.printPlayerCard(game.getPlayers());
    }

    private void playGame(Game game) {
        game.getPlayers().forEach(this::receive);
        if (game.giveCardToDealer()) {
            OutputView.printMessageToGiveCardToDealer();
        }
    }

    private void finishGame(Game game) {
        Winner winner = new Winner(game);

        OutputView.printGameResults(game.getDealer(), game.getPlayers());

        OutputView.printGameWinOrLose(game.getDealer(), winner.calculateDealerGameResult());
        game.getPlayers().forEach(
            player -> OutputView.printGameWinOrLose(
                player, winner.calculatePlayerGameResult(player)
            )
        );
    }

    public void receive(Player player) {
        Gameable gameable = player.getCards();
        String yesOrNo = "";
        do {
            yesOrNo = InputView.inputYesOrNo(player.getName());
            if (yesOrNo.equals("y")) {
                gameable.addCard(CardDeck.pop());
                OutputView.printCurrentCardsState(player.getName(), player.getCards());
                System.out.println(player.getCards().cards().sumScore());
                gameable = gameable.judge();
            }
            if (yesOrNo.equals("n")) {
                gameable = new State(gameable.cards(), false);
            }
        } while (gameable.isEnd());
    }


}
