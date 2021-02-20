package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Deck;
import blackjack.domain.FinalResult;
import blackjack.domain.Gamer;
import blackjack.domain.Gamers;
import blackjack.view.InputView;
import blackjack.view.ResultView;

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

    public void joinPlayers() {
        deck = new Deck(true);
        dealer = new Dealer(deck);
        gamers = new Gamers(inputView.getGamers(), deck);
        for (Gamer gamer : gamers.getGamers()) {
            String money = inputView.askGameMoney(gamer.getName());
            gamer.setMoney(money);
        }
        resultView.printGamers(gamers);
        resultView.printInitialCards(dealer, gamers);
    }

    public void askMoreCard() {
        gamers.getGamers().forEach(this::askMoreCardEachGamer);
    }

    private void askMoreCardEachGamer(Gamer gamer) {
        String answer;
        do {
            answer = inputView.askMoreCard(gamer.getName());
            gamer.getMoreCard(answer, deck);
            answer = checkBust(gamer, answer);
        } while (answer.equals("y"));
        resultView.printCards(gamer);
    }

    private String checkBust(Gamer gamer, String answer) {
        if (gamer.getScore().getValue() > 21) {
            resultView.printBust();
            answer = "y";
        }
        return answer;
    }

    public void getMoreCardDealer() {
        resultView.printIsGotMoreCard(dealer.addCardUnderScore(deck));
    }

    public void calculateResult() {
        finalResult = new FinalResult();
        finalResult.calculateFinalWinner(dealer, gamers);
    }

    public void showResult() {
        resultView.showResultDealer(dealer);
        for (Gamer gamer : gamers.getGamers()) {
            resultView.showResultGamer(gamer);
        }
        resultView.showWinLoseCountDealer(finalResult.getWinCount(), finalResult.getLoseCount());
        resultView.showWinLoseResultGamers(finalResult.getFinalWinner());
    }
}
