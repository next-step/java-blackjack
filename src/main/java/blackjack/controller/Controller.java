package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.MatchScoreBoard;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class Controller {
    private final InputView input;
    private final OutputView output;

    public Controller(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void playGame() {
        Players players = Players.create(input.requestPlayers());
        Dealer dealer = new Dealer();
        Deck deck = new Deck();

        dealer.drawCardFromDeck(deck);
        dealer.drawCardFromDeck(deck);

        players.initPlayers(deck);

        output.printCardInfo(dealer.getPersonInfo());
        output.printPeopleInfo(players.getPlayersInfo());

        while (players.hasActivePlayer()) {
            doActivePlayerTurn(players, deck);
        }

        while (dealer.canDrawCard()) {
            dealer.drawCardFromDeck(deck);
            output.printDealerDrawInformation();
        }

        output.printCardInfo(dealer.getPersonInfo());
        output.printPeopleInfo(players.getPlayersInfo());

        MatchScoreBoard matchScoreBoard = players.playMatch(dealer);

        output.printScoreGuideMsg();
        output.printDealerScoreInfo(
            dealer.getNameInfo(),
            matchScoreBoard.getDealerScoreInfo()
        );
        output.printPlayersScoreInfo(
            matchScoreBoard.getPlayersScoreInfo()
        );
    }

    void doActivePlayerTurn(Players players, Deck deck) {
        while (players.checkActivePlayerCanDrawCard()
            && input.requestCard(players.getActivePlayerNameInfo())
        ) {
            players.drawActivePlayerFromDeck(deck);
            output.printCardInfo(players.getActivePlayerInfo());
        }
        players.endActivePlayerTurn();
    }
}
