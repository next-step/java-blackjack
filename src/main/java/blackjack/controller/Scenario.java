package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Exporter;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

public class Scenario {

    private final Players players;
    private final Player DEALER;
    private final List<Player> GAMERS;

    public Scenario(final Players players) {
        this.players = players;
        DEALER = players.getPlayers(player -> player.getJob() == Job.DEALER).get(0);
        GAMERS = players.getPlayers(player -> player.getJob() == Job.GAMER);
    }

    /**
     * @Description. 게임 시작 시 게임 참가자에게 카드를 나눠준다.
     * 딜러 1장, 게이머 2장의 카드를 받는다.
     */
    public void prepareGame() {
        DEALER.receiveCard();
        GAMERS.forEach(Player::receiveCard);
        GAMERS.forEach(Player::receiveCard);
    }

    /**
     * @Description. 게이머가 카드를 받는지 물어본다.
     */
    public void startGame(final InputView inputView) {
        GAMERS.forEach(player -> isPopCard(inputView, player));
        if(DEALER.getCardsScore() < 16){
            DEALER.receiveCard();
        }
    }

    /**
     * @Description. 게임 결과를 본다.
     */
    public void endGame(final OutputView outputView) {
        final Exporter exporter = new Exporter(players);
        outputView.winningBoard(exporter);
    }

    private void isPopCard(InputView inputView, Player player) {
        while (inputView.isPopCard(player.getName())) {
            player.receiveCard();
        }
    }
}