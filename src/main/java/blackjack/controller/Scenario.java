package blackjack.controller;

import blackjack.model.Player;
import blackjack.model.Players;
import blackjack.view.Exporter;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Scenario {

    private final Players players;

    public Scenario(final Players players) {
        this.players = players;
    }

    /**
     * @Description. 게임 시작 시 게임 참가자에게 카드를 나눠준다.
     * 딜러 1장, 게이머 2장의 카드를 받는다.
     */
    public void prepareGame() {
        //TODO : eqauls(하드코딩), 하드코딩 유지보수
        players.receive(player -> player.getName().equals("Dealer"));  //딜러가 카드 한장을 받는다.
        players.receive(player -> !player.getName().equals("Dealer")); //게이머가 카드 한장을 받는다.
        players.receive(player -> !player.getName().equals("Dealer")); //게이머가 카드 한장을 받다.
    }

    /**
     * @Description. 게이머가 카드를 받는지 물어본다.
     */
    public void startGame(final InputView inputView) {
        players.getPlayers().forEach(player -> isPopCard(inputView, player));
    }

    /**
     * @Description. 게임 결과를 본다.
     */
    public void endGame(final OutputView outputView) {
        final Exporter exporter = new Exporter(players);
        outputView.printResult(exporter.getResult());
    }

    private void isPopCard(InputView inputView, Player player) {
        while (inputView.isPopCard(player.getName())) {
            player.receiveCard();
        }
    }
}