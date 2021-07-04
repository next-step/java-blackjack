package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Input;
import blackjack.view.Output;

import java.util.Arrays;
import java.util.List;

import static blackjack.model.CardSeparator.canUserReceiveCard;

public class BlackJackController {
    private static final String SPLIT_SEPARATOR = ",";
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
        Referee.makeWinningStates(dealer, users);

        String result = Referee.makeResult(dealer, users);
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
}
