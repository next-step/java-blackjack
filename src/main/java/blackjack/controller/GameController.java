package blackjack.controller;

import static blackjack.domain.Dealer.DEALER_DRAW_LIMIT;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.domain.ScoreBoard;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class GameController {

    private final Players players;
    private final Dealer dealer;

    public GameController() {
        this.players = Players.create(InputView.getNames());
        this.dealer = new Dealer();
    }

    public void run() {
        final Deck deck = Deck.create();

        setUpPerson(deck);
        play(deck);
        showGameResult();
    }

    private void setUpPerson(Deck deck) {
        ResultView.margin();

        players.initializeDeck(deck);
        dealer.initializeDeck(deck);

        ResultView.shareCards(dealer.mapToNameInfo().getPersonName(), players.getPlayersName());
        ResultView.openCardInfo(dealer.openCards(), players.openCards());
    }

    private void play(Deck deck) {
        ResultView.margin();

        playersJudgment(deck);
        dealerJudgment(deck);

        ResultView.scoreboard(dealer.getScoreInfo());
        ResultView.scoreboard(players.getScoreInfo());
    }

    private void showGameResult() {
        ScoreBoard scoreBoard = players.match(dealer);
        ResultView.matchResult(scoreBoard.getDealerMatchInfo(dealer), scoreBoard.getPlayersMatchInfo());
    }

    private void playersJudgment(Deck deck) {
        while (players.hasActivePlayer()) {
            activePlayerJudgement(deck);
        }
    }

    private void activePlayerJudgement(Deck deck) {
        while (players.checkActivePlayerCanDrawCard() && InputView.drawChoice(players.getActivePlayerNameInfo())) {
            players.drawCardToActivePlayer(deck);
            ResultView.playerCardsInfo(players.getActivePlayerCardsInfo());
        }
        players.nextActivePlayer();
    }

    private void dealerJudgment(Deck deck) {
        ResultView.margin();

        while (dealer.canDrawCard()) {
            dealer.drawCard(deck);
            ResultView.dealerDrawDecision(dealer.mapToNameInfo(), DEALER_DRAW_LIMIT);
        }

        ResultView.margin();
    }

}
