package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.FinalResult;
import blackjack.domain.Gamer;
import blackjack.domain.Gamers;
import blackjack.view.InputView;
import blackjack.view.ResultView;
import java.util.Arrays;

public class BlackjackController {

    InputView inputView;
    ResultView resultView;
    Deck deck;
    Gamers gamers;
    Dealer dealer;
    FinalResult finalResult;

    public BlackjackController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void gameStart() {
        joinPlayers();
        askMoreCard();
        getMoreCardDealer();
        calculateResult();
        showResult();
    }

    private void joinPlayers() {
        deck = new Deck();
        dealer = new Dealer(deck);
        try {
            gamers = new Gamers(
                inputView.getGamers(),
                deck
            );
            resultView.printGamers(gamers);
            resultView.printInitialCards(dealer, gamers);
        } catch (IllegalArgumentException e) {
            resultView.printErrorGamersNameFormat();
            joinPlayers();
        }
    }

    private void askMoreCard() {
        gamers.getGamers().forEach(this::askMoreCardEachGamer);
    }

    private void askMoreCardEachGamer(Gamer gamer) {
        String answer;
        do {
            answer = inputView.askMoreCard(gamer.getName());
            gamer.getMoreCard(answer);
        } while (answer.equals("y"));
        resultView.printCards(gamer);
    }

    public void getMoreCardDealer() {
        resultView.printIsGotMoreCard(dealer.addCardUnderScore());
    }

    public void calculateResult() {
        finalResult = new FinalResult();
        finalResult.calculateFinalWinner(dealer, gamers);
    }

    public void showResult() {
        resultView.showResultDealer(dealer.getCards().toString(), dealer.getScore().getValue());
        resultView.showResultGamers(Arrays.asList(gamers.toString().split("\n")), finalResult.getScores());
        resultView.showWinLoseCountDealer(finalResult.getWinCount(), finalResult.getLoseCount());
        resultView.showWinLoseResultGamers(finalResult.getFinalWinner());
    }
}
