package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.domain.PlayersFactory;
import blackjack.domain.ScoreBoard;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.Map;

public class BlackJackController {

    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final Deck deck;

    public BlackJackController() {
        this.deck = new Deck();
    }

    public void startGame() {
        Players players = PlayersFactory.generatePlayers(input.requestPlayers());
        Dealer dealer = new Dealer();

        initCards(dealer, players);
        playerTurn(players);
        dealerTurn(dealer);
        calculateScore(dealer, players);
        finalResult(dealer, players);
    }

    private void initCards(Dealer dealer, Players players) {
        dealer.initialCard(deck);
        players.initCards(deck);

        output.printInitialCardDrawInfo(players.getPlayersInfo().getNameInfo());
        output.printDealerCardInfo(dealer.getFirstCard());
        output.printPlayersCardInfo(players.getPlayersInfo().getPeopleInfo());
    }

    private void dealerTurn(Dealer dealer) {
        while (dealer.canDraw()) {
            dealer.drawCard(deck);
            output.printDealerDrawInformation();
        }
    }

    private void playerTurn(Players players) {
        while (players.hasUser()) {
            drawCard(players);
            players.incrementPlayerIndex();
        }
    }

    private void drawCard(Players players) {
        while (players.getCurrentPlayerStatus()
                && input.requestCard(players.getCurrentPlayerNameInfo())) {
            players.drawCurrentPlayerCard(deck);
            output.printCardInfo(players.getCurrentPlayerPersonInfo());
        }
    }

    private void calculateScore(Dealer dealer, Players players) {
        output.printDealerCardScore(dealer.getPersonInfo(), dealer.getScore());
        output.printPlayersCardScore(players.getPlayersInfo().getPeopleInfo());
    }

    private void finalResult(Dealer dealer, Players players) {
        ScoreBoard scoreBoard = new ScoreBoard();
        Map<String, String> result = players.getResult(dealer, scoreBoard);
        output.printFinalResult(result, scoreBoard.getScoreBoardInfo());
    }
}
