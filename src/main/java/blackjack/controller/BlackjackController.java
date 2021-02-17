package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.FinalResult;
import blackjack.domain.Gamer;
import blackjack.domain.Gamers;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackjackController {

    private final InputView inputView;
    private final ResultView resultView;
    private Gamers gamers;
    private Dealer dealer;
    private FinalResult finalResult;

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
        Deck deck = new Deck();
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

    private void getMoreCardDealer() {
        resultView.printIsGotMoreCard(dealer.addCardUnderScore());
    }

    private void calculateResult() {
        finalResult = new FinalResult();
        finalResult.calculateFinalResult(dealer, gamers);
        finalResult.calculateGamerScore(gamers);
    }

    private void showResult() {
        resultView.showResultDealer(dealer.getCards().toString(), dealer.getScore().getValue());
        resultView.showResultGamers(gamers.getGamerInfo(), finalResult.getScores());
        resultView.showWinLoseCountDealer(dealer.getWinCount(), dealer.getLoseCount());
        resultView.showWinLoseResultGamers(finalResult.getFinalWinner());
    }
}
