package blackjack.controller;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {
    private final static int DEALER_HIT_CONDITION = 16;

    final private InputView inputView;
    final private OutputView outputView;

    public BlackjackController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Players inputGamerNames() {
        return inputView.inputGamerNames();
    }

    public void prepareGame(final Players players) {
        final Exporter exporter = new Exporter(players);

        players.receiveCards(player -> true);
        players.receiveCards(player -> true);

        outputView.printResult(exporter.initialCardDistribution());
    }

    public void hitGamer(final Players players) {
        players.getPlayers(player -> player.getJob() == Job.GAMER).forEach(this::isPopCard);
    }

    public void hitDealer(final Players players) {
        final Exporter exporter = new Exporter(players);
        final Player dealer = players.getDealer();

        if (dealer.getCardsScore() < DEALER_HIT_CONDITION) {
            dealer.receiveCard();
        }

        outputView.printResult(exporter.getPlayersCardsStatusWithScore());
    }

    public void standGame(final Players players) {
        final GameResult gameResult = new GameResult(players);
        final Exporter exporter = new Exporter(players);
        final String endGameResult = exporter.getResult(gameResult);

        outputView.gameScore(endGameResult);
    }

    private void isPopCard(final Player player) {
        while (inputView.isPopCard(player.getName())) {
            player.receiveCard();
            outputView.printResult(player.getCardStats().getCardsName());
        }
    }
}