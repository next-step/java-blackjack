package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.MatchScoreBoard;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import static blackjack.domain.Person.INIT_CARD_CNT;

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

        dealer.initializeFromDeck(deck);
        players.initializeFromDeck(deck);

        output.printInitGameMsg(
            dealer.getNameInfo(),
            players.getPlayersNameInfo(),
            INIT_CARD_CNT
        );
        output.printPersonCardsInfo(dealer.getPersonCardsInfo());
        output.printPeopleCardsInfo(players.getPlayersCardsInfo());

        while (players.hasActivePlayer()) {
            doActivePlayerTurn(players, deck);
        }

        while (dealer.canDrawCard()) {
            dealer.drawCardFromDeck(deck);
            output.printDealerDrawInformation();
        }

        output.printScoreInfo(dealer.getScoreInfo());
        output.printScoresInfo(players.getPlayersScoreInfo());

        MatchScoreBoard matchScoreBoard = players.playMatch(dealer);

        output.printMatchScoreGuideMsg();
        output.printDealerMatchScoreInfo(
            matchScoreBoard.getDealerMatchScoreInfo()
        );
        output.printPlayersMatchScoreInfo(
            matchScoreBoard.getPlayersMatchScoreInfo()
        );
    }

    void doActivePlayerTurn(Players players, Deck deck) {
        while (players.checkActivePlayerCanDrawCard()
            && input.requestCard(players.getActivePlayerNameInfo())
        ) {
            players.drawActivePlayerFromDeck(deck);
            output.printPersonCardsInfo(players.getActivePlayerCardsInfo());
        }
        players.endActivePlayerTurn();
    }
}
