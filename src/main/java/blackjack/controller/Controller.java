package blackjack.controller;

import blackjack.domain.Game;
import blackjack.domain.Winner;
import blackjack.domain.card.CardDeck;
import blackjack.domain.player.Player;
import blackjack.domain.state.Gameable;
import blackjack.domain.state.State;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Controller {

    private static final String BLANK = "";
    private static final String YES_MESSAGE = "y";
    private static final String NO_MESSAGE = "y";

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

    private void receive(Player player) {
        Gameable gameable = player.getCards();
        String yesOrNo = BLANK;
        do {
            yesOrNo = InputView.inputYesOrNo(player.getName());
            if (yesOrNo.equals(YES_MESSAGE)) {
                gameable.addCard(CardDeck.pop());
                OutputView.printCurrentCardsState(player.getName(), player.getCards());
                gameable = gameable.judge();
            }
            if (yesOrNo.equals(NO_MESSAGE)) {
                gameable = new State(gameable.cards(), false);
            }
        } while (gameable.isEnd());
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

}
