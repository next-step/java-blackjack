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

    private void setUpPerson(final Deck deck) {
        ResultView.margin();

        players.initializeDeck(deck);
        dealer.initializeDeck(deck);

        ResultView.shareCards(dealer.nameInfo().getPersonName(), players.nameInfos());
        ResultView.openCardInfo(dealer.openCards(), players.openCards());
    }

    private void play(final Deck deck) {
        ResultView.margin();

        playersJudgment(deck);
        dealerJudgment(deck);

        ResultView.scoreboard(dealer.scoreInfo());
        ResultView.scoreboard(players.scoreInfos());
    }

    private void showGameResult() {
        ScoreBoard scoreBoard = players.match(dealer);
        ResultView.matchResult(scoreBoard.dealerMatches(dealer),
            scoreBoard.playerMatches());
    }

    private void playersJudgment(final Deck deck) {
        while (players.hasActivePlayer()) {
            activePlayerJudgement(deck);
        }
    }

    private void activePlayerJudgement(final Deck deck) {
        while (players.checkActivePlayerCanDrawCard() && InputView.drawChoice(
            players.getActivePlayerNameInfo())) {
            players.drawCardToActivePlayer(deck);
            ResultView.playerCardsInfo(players.getActivePlayerCardInfo());
        }
        players.nextActivePlayer();
    }

    private void dealerJudgment(final Deck deck) {
        ResultView.margin();

        while (dealer.canDrawCard()) {
            dealer.drawCard(deck);
            ResultView.dealerDrawDecision(dealer.nameInfo(), DEALER_DRAW_LIMIT);
        }

        ResultView.margin();
    }

}
