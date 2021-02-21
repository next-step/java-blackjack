package blackjack.controller;

import blackjack.domain.*;
import blackjack.view.InputView;
import blackjack.view.ResultView;

public class BlackjackController {

    private static final int BLACKJACK = 21;
    private static final String YES = "y";
    private static final String DEALER_NAME = "\n딜러";

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
        } while (answer.equals(YES));
        resultView.printCards(gamer);
    }

    private String checkBust(Gamer gamer, String answer) {
        gamer.calculateScore();
        if (gamer.getScore().getValue() > BLACKJACK) {
            resultView.printBust();
            answer = YES;
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
        resultView.showEarningMoney(DEALER_NAME, finalResult.getMoneyOfDealer());
        finalResult.getFinalWinner().forEach((name, result) -> resultView.showEarningMoney(name, result));
    }
}
