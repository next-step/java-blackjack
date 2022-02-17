package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.GameResult;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.ui.BlackjackInput;
import blackjack.ui.BlackjackOutput;

public class GameController {

    private static final String DEALER_NAME = "dealer";
    private static final int PLAYER_DRAW_SIZE = 1;
    private static final int DEALER_DRAW_SIZE = 1;
    private static final int FIRST_DRAW_SIZE = 2;

    public void start() {
        Deck deck = Deck.create();

        Players players = BlackjackInput.inputPlayerName();
        Dealer dealer = new Dealer(DEALER_NAME);

        drawCardInit(deck, players, dealer);

        drawCardFinal(deck, players, dealer);

        BlackjackOutput.printFinalResult(GameResult.of(dealer, players));
    }

    private void drawCardInit(Deck deck, Players players, Dealer dealer) {
        BlackjackOutput.printDrawCard(players);
        players.drawCardMultiple(deck, FIRST_DRAW_SIZE);
        dealer.drawCardMultiple(deck, FIRST_DRAW_SIZE);
        BlackjackOutput.printAllCard(players, dealer);

    }

    private void drawCardFinal(Deck deck, Players players, Dealer dealer) {
        drawPlayersCard(deck, players, PLAYER_DRAW_SIZE);
        dealer.drawCardMultiple(deck, DEALER_DRAW_SIZE);

        BlackjackOutput.printAllCard(players, dealer);
    }

    private void drawPlayersCard(Deck deck, Players players, int size) {
        if (players.isTargetAvailable()) {
            return;
        }

        Player player = players.getTarget();
        while (BlackjackInput.inputPlayerDraw()) {
            player.drawCardMultiple(deck, size);
            BlackjackOutput.printParticipantCard(player);
        }

        players.nextTargetIndex();
        drawPlayersCard(deck, players, size);
    }
}
