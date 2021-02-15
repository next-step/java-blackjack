package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.MatchScoreBoard;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import static blackjack.domain.Dealer.DEALER_DRAW_LIMIT;
import static blackjack.domain.Person.INIT_CARD_CNT;

public class PeopleController {
    private final Players players;
    private final Dealer dealer;

    public PeopleController(Players players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public void actionStandByPhase(OutputView output, Deck deck) {
        dealer.initializeFromDeck(deck);
        players.initializeFromDeck(deck);

        output.printInitializeGameMsg(dealer.getNameInfo(), players.getPlayersNameInfo(), INIT_CARD_CNT);
        output.printPersonCardsInfo(dealer.getPersonCardsInfoFirstCardOnly());
        output.printPeopleCardsInfo(players.getPlayersCardsInfo());
    }

    public void actionMainPhase(InputView input, OutputView output, Deck deck) {
        actionPlayersMainPhase(input, output, deck);
        actionDealerMainPhase(output, deck);

        output.printScoreInfo(dealer.getScoreInfo());
        output.printScoresInfo(players.getPlayersScoreInfo());
    }

    private void actionPlayersMainPhase(InputView input, OutputView output, Deck deck) {
        while (players.hasActivePlayer()) {
            actionActivePlayerMainPhase(input, output, deck);
        }
    }

    private void actionActivePlayerMainPhase(InputView input, OutputView output, Deck deck) {
        while (players.checkActivePlayerCanDrawCard()
            && input.inputResponse(players.getActivePlayerNameInfo())
        ) {
            players.drawActivePlayerFromDeck(deck);
            output.printPersonCardsInfo(players.getActivePlayerCardsInfo());
        }
        players.endActivePlayerTurn();
    }

    private void actionDealerMainPhase(OutputView output, Deck deck) {
        output.printDealerInfoMargin();
        while (dealer.canDrawCard()) {
            dealer.drawCardFromDeck(deck);
            output.printDealerDrawInformation(dealer.getNameInfo(), DEALER_DRAW_LIMIT);
        }
        output.printDealerInfoMargin();
    }

    public void actionEndPhase(OutputView output) {
        MatchScoreBoard matchScoreBoard = players.playMatch(dealer);

        output.printMatchScoreGuideMsg();
        output.printDealerMatchScoreInfo(dealer.getNameInfo(), matchScoreBoard.getDealerMatchScoreInfo());
        output.printPlayersMatchScoreInfo(matchScoreBoard.getPlayersMatchScoreInfo());
    }
}
