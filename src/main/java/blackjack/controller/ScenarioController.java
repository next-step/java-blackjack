package blackjack.controller;

import blackjack.model.Exporter;
import blackjack.model.Job;
import blackjack.model.Player;
import blackjack.model.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.List;

public class ScenarioController {
    private final Player DEALER;
    private final List<Player> GAMERS;
    private final Exporter exporter;
    private final static int DEALER_HIT_CONDITION = 16;

    public ScenarioController(final Players players) {
        DEALER = players.getPlayers(player -> player.getJob() == Job.DEALER).get(0);
        GAMERS = players.getPlayers(player -> player.getJob() == Job.GAMER);
        exporter = new Exporter(players);
    }

    /**
     * @Description. 게임 시작 시 게임 참가자에게 카드를 나눠준다.
     * 딜러 1장, 게이머 2장의 카드를 받는다.
     */
    public String prepareGame() {
        DEALER.receiveCard();
        GAMERS.forEach(Player::receiveCard);
        GAMERS.forEach(Player::receiveCard);

        return exporter.initialCardDistribution();
    }

    /**
     * @Description. 게이머가 카드를 받는지 물어본다.
     */
    public String startGame(final InputView inputView, final OutputView outputView) {
        GAMERS.forEach(player -> isPopCard(inputView, outputView, player));
        if (DEALER.getCardsScore() < DEALER_HIT_CONDITION) {
            DEALER.receiveCard();
        }

        return exporter.getPlayersCardsStatusWithScore();
    }

    /**
     * @Description. 게임 결과를 본다.
     */
    public String endGame() {
        return exporter.getResult();
    }

    //TODO : 메소드 인스턴스 변수 줄이기
    private void isPopCard(final InputView inputView, final OutputView outputView, final Player player) {
        while (inputView.isPopCard(player.getName())) {
            player.receiveCard();
            outputView.printResult(String.format("%s 카드: %s", player.getName(), player.getCardStats().getCardsName()));
        }
    }
}