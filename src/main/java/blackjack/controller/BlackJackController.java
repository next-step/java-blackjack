package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Input;
import blackjack.view.Output;

import java.util.Arrays;
import java.util.List;


public class BlackJackController {
    private static final String SPLIT_SEPARATOR = ",";
    private static final int FIRST_CARD_INDEX = 0;
    private static final int STARTING_CARD_COUNT = 2;
    private static final String GET_RECEIVE_CARD = "y";
    private static final String WINNING_STATE_SEPARATOR = ": ";
    private static final CardGenerator cardGenerator = new CardGenerator();

    public void blankJackStart() {
        Player dealer = PlayerFactory.of("딜러");
        initPlayer(dealer);

        List<String> userNames = Arrays.asList(Input.inputNames().split(SPLIT_SEPARATOR));
        Players users = new Players(userNames);
        initUsers(users.getUser());
        Output.printInitMessage(users.getUserNames());

        Output.printDealerCardName(dealer.getName(), dealer.getCardNames().get(FIRST_CARD_INDEX));
        printUsersCardNames(users);

        doUsersTurn(users);
        doDealerTurn(dealer);

        Output.printPlayerCardInformation(dealer);
        printUsersCardInformation(users);

        makeWinningState2(dealer, users);
        String result = makeResult(dealer, users.getUser());
        Output.printResult(result);
    }

    private void initPlayer(Player player) {
        player.addSeveralCard(cardGenerator.getSeveralCard(STARTING_CARD_COUNT));
    }

    private void initUsers(List<Player> users) {
        for (Player user : users) {
            initPlayer(user);
        }
    }

    private void printUsersCardNames(Players users) {
        for (Player user : users.getUser()) {
            Output.printCardNames(user.getName(), user.getCardNames());
        }
    }

    private void doUsersTurn(Players users) {
        for (Player user : users.getUser()) {
            doUserTurn(user);
        }
    }

    private void doDealerTurn(Player dealer) {
        if (dealer.canReceiveCard()) {
            dealer.addCard(cardGenerator.getOneCard());
            Output.printDealerReceiveCard();
        }
    }

    private void doUserTurn(Player user) {
        boolean userTurn = true;

        while (userTurn) {
            userTurn = isUserTurn(user);
        }
    }

    private boolean isUserTurn(Player user) {
        if (user.canReceiveCard()) {
            return isReceiveCard(user);
        }

        return false;
    }

    private boolean isReceiveCard(Player user) {
        if (Input.inputReceiveCardAnswer(user.getName()).equals(GET_RECEIVE_CARD)) {
            user.addCard(cardGenerator.getOneCard());
            Output.printCardNames(user.getName(), user.getCardNames());
            return true;
        }

        return false;
    }

    private void printUsersCardInformation(Players users) {
        for (Player user : users.getUser()) {
            Output.printPlayerCardInformation(user);
        }
    }

    private void makeWinningState2(Player dealer, Players users) {
        for (Player user : users.getUser()) {
            if(burstCheck(dealer)){
                if(!burstCheck(user)){
                    dealer.getWinningState().plusLoseCount();
                    user.getWinningState().plusWinCount();
                }
                continue;
            }
            if(burstCheck(user)){
                dealer.getWinningState().plusWinCount();
                user.getWinningState().plusLoseCount();
            }
            if(!burstCheck(user)){
                if (dealer.getCardValueSum() > user.getCardValueSum()) {
                    dealer.getWinningState().plusWinCount();
                    user.getWinningState().plusLoseCount();
                }
                if (dealer.getCardValueSum() < user.getCardValueSum()) {
                    dealer.getWinningState().plusLoseCount();
                    user.getWinningState().plusWinCount();
                }
            }
        }
    }

    private boolean burstCheck(Player player) {
        return player.getCardValueSum() > 21;
    }

    private String makeResult(Player dealer, List<Player> users) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(dealer.getName()).append(WINNING_STATE_SEPARATOR)
                .append(makeDealerResult(dealer));

        for (Player user : users) {
            stringBuilder.append(user.getName())
                    .append(WINNING_STATE_SEPARATOR)
                    .append(makeUserResult(user));
        }

        return stringBuilder.toString();
    }

    private StringBuilder makeDealerResult(Player dealer) {
        StringBuilder stringBuilder = new StringBuilder();

        if (dealer.getWinningState().getWinCount() > 0) {
            stringBuilder.append(dealer.getWinningState().getWinCount())
                    .append("승 ");
        }
        if (dealer.getWinningState().getLoseCount() > 0) {
            stringBuilder.append(dealer.getWinningState().getLoseCount())
                    .append("패 ");
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }

    private StringBuilder makeUserResult(Player user) {
        StringBuilder stringBuilder = new StringBuilder();

        if (user.getWinningState().getWinCount() > 0) {
            stringBuilder.append("승 ");
        }
        if (user.getWinningState().getLoseCount() > 0) {
            stringBuilder.append("패 ");
        }
        stringBuilder.append(System.lineSeparator());

        return stringBuilder;
    }
}
