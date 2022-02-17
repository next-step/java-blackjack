package blackjack.controller;


import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.Players;
import blackjack.view.ResultView;

public class PeopleController {

    private final Players players;
    private final Dealer dealer;

    public PeopleController(Players players, Dealer dealer) {
        this.players = players;
        this.dealer = dealer;
    }

    public void setUpPerson(Deck deck) {
        players.initializeDeck(deck);
        dealer.initializeDeck(deck);
    }

    public void play(Deck deck) {
        playersJudgment(deck);
        dealerJudgment(deck);

        ResultView.shareCards(dealer.mapToNameInfo().getPersonName(), players.getPlayersName());
        ResultView.openCardInfo(dealer.openCards(), players.openCards());
    }

    private void playersJudgment(Deck deck) {

    }

    private void dealerJudgment(Deck deck) {

    }

    public void showGameResult() {

    }
}
