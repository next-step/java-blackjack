package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Input;
import blackjack.view.Output;

import java.util.Arrays;
import java.util.List;


public class BlackJackController {
    private static final String SPLIT_SEPARATOR = ",";
    private static final int STARTING_CARD_COUNT = 2;
    private static final String GET_RECEIVE_CARD = "y";
    private static final CardGenerator cardGenerator = new CardGenerator();

    public void blankJackStart() {
        Dealer dealer = new Dealer();
        initPlayer(dealer);

        List<String> userNames = Arrays.asList(Input.inputNames().split(SPLIT_SEPARATOR));
        Users users = new Users(userNames);
        initUsers(users.getUser());

        Output.printInitMessage(users.getUserNames());
        Output.printCardNames("딜러", dealer.getCardName());

        printUsersCardNames(users);

        doUsersTurn(users);

        doDealerTurn(dealer);

    }

    private void doDealerTurn(Dealer dealer) {
        if (dealer.canReceiveCard()) {
            dealer.addCard(cardGenerator.getOneCard());
            Output.printDealerReceiveCard();
        }
    }

    private void initPlayer(Player player) {
        player.addSeveralCard(cardGenerator.getSeveralCard(STARTING_CARD_COUNT));
    }

    private void initUsers(List<User> users) {
        for (User user : users) {
            initPlayer(user);
        }
    }

    private void printUsersCardNames(Users users) {
        for (User user : users.getUser()) {
            Output.printCardNames(user.getName(), user.getCardNames());
        }
    }

    private void doUsersTurn(Users users) {
        for (User user : users.getUser()) {
            doUserTurn(user);
        }
    }

    private void doUserTurn(User user) {
        boolean userTurn = true;

        while (userTurn) {
            userTurn = isUserTurn(user);
        }
    }

    private boolean isUserTurn(User user) {
        if (user.canReceiveCard()) {
            return isReceiveCard(user);
        }

        return false;
    }

    private boolean isReceiveCard(User user) {
        if (Input.inputReceiveCardAnswer(user.getName()).equals(GET_RECEIVE_CARD)) {
            user.addCard(cardGenerator.getOneCard());
            Output.printCardNames(user.getName(), user.getCardNames());
            return true;
        }

        return false;
    }
}
