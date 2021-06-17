package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Input;
import blackjack.view.Output;

import java.util.Arrays;
import java.util.List;

public class BlackJackController {
    private static final int HAVE_COUNT = 0;
    private static final String SPLIT_SEPARATOR = ",";
    private static final String WINNING_STATE_SEPARATOR = ": ";
    private static final String WIN = "승 ";
    private static final String LOSE = "패 ";

    public void blankJackStart() {
        Dealer dealer = PlayerGenerator.makeDealer();
        List<String> userNames = Arrays.asList(Input.inputNames().split(SPLIT_SEPARATOR));
        Users users = PlayerGenerator.makeUsers(userNames);

        Output.printInitMessage(users.getUserNames());

        doPlayersInitialPrintLogic(dealer, users);
        doPlayersTurnLogic(dealer, users);

        doPlayersCardInformationPrintLogic(dealer, users);
        doMakeWinningStateLogic(dealer, users);
        doMakeResultLogic(dealer, users);
    }

    private void doPlayersInitialPrintLogic(Dealer dealer, Users users) {
        Output.printDealerFirstCardName("딜러", dealer.getFirstCard());
        printUsersCardNames1(users);
    }

    private void printUsersCardNames1(Users users) {
        for (User user : users.getUsers()) {
            Output.printCardNames(user.getName(), user.getCardNames());
        }
    }

    private void doPlayersTurnLogic(Dealer dealer, Users users) {
        CardSeparator.doUsersTurn(users);
        CardSeparator.doDealerTurn(dealer);
    }

    private void doPlayersCardInformationPrintLogic(Dealer dealer, Users users) {
        Output.printDealerCardInformation(dealer);
        printUsersCardInformation(users);
    }

    private void printUsersCardInformation(Users users) {
        for (User user : users.getUsers()) {
            Output.printUserCardInformation(user);
        }
    }

    private void doMakeWinningStateLogic(Dealer dealer, Users users) {
        for (User user : users.getUsers()) {
            makeWinningState(dealer, user);
        }
    }

    private void makeWinningState(Dealer dealer, User user) {
        if (dealer.isBust()) {
            dealerLoseLogic(dealer, user);
            return;
        }

        if (user.isBust()) {
            userLoseLogic(dealer, user);
            return;
        }

        comparePlayersLogic(dealer, user);
    }

    private void dealerLoseLogic(Dealer dealer, User user) {
        boolean isNotUserBust = !user.isBust();

        if (isNotUserBust) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
    }

    private void userLoseLogic(Dealer dealer, User user) {
        dealer.getWinningState().plusWinCount();
        user.getWinningState().plusLoseCount();
    }

    private void comparePlayersLogic(Dealer dealer, User user) {
        if (dealer.getCardValueSum() > user.getCardValueSum()) {
            dealer.getWinningState().plusWinCount();
            user.getWinningState().plusLoseCount();
        }
        if (dealer.getCardValueSum() < user.getCardValueSum()) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
    }

    private void doMakeResultLogic(Dealer dealer, Users users) {
        String result = makeResult(dealer, users.getUsers());
        Output.printResult(result);
    }

    private String makeResult(Dealer dealer, List<User> users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(dealer.getName()).append(WINNING_STATE_SEPARATOR)
                .append(makeDealerResult(dealer));

        for (User user : users) {
            stringBuilder.append(user.getName())
                    .append(WINNING_STATE_SEPARATOR)
                    .append(makeUserResult(user));
        }

        return stringBuilder.toString();
    }

    private StringBuilder makeDealerResult(Dealer dealer) {
        StringBuilder stringBuilder = new StringBuilder();
        if (dealer.getWinningState().getWinCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getWinningState().getWinCount())
                    .append(WIN);
        }
        if (dealer.getWinningState().getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getWinningState().getLoseCount())
                    .append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }

    private StringBuilder makeUserResult(User user) {
        StringBuilder stringBuilder = new StringBuilder();

        if (user.getWinningState().getWinCount() > HAVE_COUNT) {
            stringBuilder.append(WIN);
        }
        if (user.getWinningState().getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }
}
