package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Input;
import blackjack.view.Output;

import java.util.Arrays;
import java.util.List;

import static blackjack.model.CardSeparator.canUserReceiveCard;

public class BlackJackController {
    private static final int HAVE_COUNT = 0;
    private static final String SPLIT_SEPARATOR = ",";
    private static final String WINNING_STATE_SEPARATOR = ": ";
    private static final String WIN = "승 ";
    private static final String DRAW = "무 ";
    private static final String LOSE = "패 ";
    private static final String GET_RECEIVE_CARD = "y";

    public void blankJackStart() {
        Dealer dealer = PlayerGenerator.makeDealer();
        List<String> userNames = Arrays.asList(Input.inputNames().split(SPLIT_SEPARATOR));
        Users users = PlayerGenerator.makeUsers(userNames);

        Output.printInitMessage(users.getUserNames());
        Output.printInitialInformation(dealer, users);

        doUsersTurn(users);
        doDealerTurn(dealer);

        Output.printFinalInformation(dealer, users);
        makeWinningStates(dealer, users);

        String result = makeResult(dealer, users);
        Output.printResult(result);
    }

    public static void doUsersTurn(Users users) {
        for (User user : users.getUsers()) {
            doUserTurn(user);
        }
    }

    public static void doDealerTurn(Dealer dealer) {
        while (CardSeparator.canDealerReceiveCard(dealer)) {
            dealer.drawCard(CardSeparator.drawCard());
            Output.printDealerReceiveCard();
        }

    }

    private static void doUserTurn(User user) {
        boolean userTurn = true;

        while (userTurn) {
            userTurn = isUserTurn(user);
        }
    }

    private static boolean isUserTurn(User user) {
        if (canUserReceiveCard(user)) {
            return wantReceiveCard(user);
        }

        return false;
    }

    private static boolean wantReceiveCard(User user) {
        if (Input.inputReceiveCardAnswer(user.getName()).equals(GET_RECEIVE_CARD)) {
            user.drawCard(CardSeparator.drawCard());
            Output.printCardNames(user.getName(), user.getCardNames());
            return true;
        }

        return false;
    }

    private void makeWinningStates(Dealer dealer, Users users) {
        for (User user : users.getUsers()) {
            Referee.makeWinningState(dealer, user);
        }
    }

    private String makeResult(Dealer dealer, Users users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(dealer.getName()).append(WINNING_STATE_SEPARATOR)
                .append(makeDealerResult(dealer));

        for (User user : users.getUsers()) {
            stringBuilder.append(user.getName())
                    .append(WINNING_STATE_SEPARATOR)
                    .append(makeUserResult(user));
        }

        return stringBuilder.toString();
    }

    private StringBuilder makeDealerResult(Dealer dealer) {
        StringBuilder stringBuilder = new StringBuilder();

        if (dealer.getWinCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getWinCount())
                    .append(WIN);
        }
        if (dealer.getDrawCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getDrawCount())
                    .append(DRAW);
        }
        if (dealer.getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(dealer.getLoseCount())
                    .append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }

    private StringBuilder makeUserResult(User user) {
        StringBuilder stringBuilder = new StringBuilder();

        if (user.getWinCount() > HAVE_COUNT) {
            stringBuilder.append(WIN);
        }
        if (user.getDrawCount() > HAVE_COUNT) {
            stringBuilder.append(DRAW);
        }
        if (user.getLoseCount() > HAVE_COUNT) {
            stringBuilder.append(LOSE);
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }
}
