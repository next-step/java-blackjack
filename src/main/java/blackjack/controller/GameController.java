package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Participant;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.ui.BlackjackInput;
import blackjack.ui.BlackjackOutput;

public class GameController {

    private static final String DEALER_NAME = "dealer";
    private static final int PLAYER_DRAW_SIZE = 1;
    private static final int DEALER_DRAW_SIZE = 1;
    private static final int FIRST_DRAW_SIZE = 2;

    public Participant start() {
        Deck deck = Deck.create();

        // Players & 딜러 생성 -> 사용자 추가
        Players players = BlackjackInput.inputPlayerName();
        Dealer dealer = new Dealer(DEALER_NAME);

        drawCardInit(deck, players, dealer);
        drawCardMax(deck, players, dealer);

        // 사용자별 카드 최종 상태 출력
        // 최종 승패 출력

        return null;
    }

    private void drawCardInit(Deck deck, Players players, Dealer dealer) {
        players.drawCardMultiple(deck, FIRST_DRAW_SIZE);
        dealer.drawCardMultiple(deck, FIRST_DRAW_SIZE);
    }

    private void drawCardMax(Deck deck, Players players, Dealer dealer) {
        drawPlayersCard(deck, players, PLAYER_DRAW_SIZE);
        dealer.drawCardMultiple(deck, DEALER_DRAW_SIZE);
    }

    private void drawPlayersCard(Deck deck, Players players, int size) {
        if(players.isTargetAvailable()){
            return;
        }

        Player player = players.getTarget();
        while (BlackjackInput.inputPlayerDraw()) {
            player.drawCardMultiple(deck, size);
            BlackjackOutput.printPlayerCard(player);
        }

        players.nextTargetIndex();
        drawPlayersCard(deck, players, size);
    }
}
