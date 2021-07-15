package blackjack.controller;

import blackjack.model.*;
import blackjack.view.Input;
import blackjack.view.Output;

import java.util.Arrays;
import java.util.List;

public class BlackJackController {
    public static final int BURST_COUNT = 21;
    private static final int FIRST_CARD_INDEX = 0;
    private static final int STARTING_CARD_COUNT = 2;

    private static final String SPLIT_SEPARATOR = ",";
    private static final String GET_RECEIVE_CARD = "y";

    private static final CardGenerator cardGenerator = new CardGenerator();

    public void blankJackStart() {
        Player dealer = PlayerFactory.of(PlayerFactory.DEALER);
        List<String> userNames = Arrays.asList(Input.inputNames().split(SPLIT_SEPARATOR));
        Players users = new Players(userNames);

        initialGame(dealer, users);
        startGameLogic(dealer, users);
        progressPlayersTurnLogic(dealer, users);
        showPlayersCardInformationLogic(dealer, users);
        WinningLogic winningLogic = new WinningLogic(dealer,users);
        GameResult gameResult = new GameResult(dealer,users);
        Output.printResult(gameResult.makeResultLogic(dealer, users));
    }

    private void initialGame(Player dealer, Players users) {
        initPlayer(dealer);
        initUsers(users.getUser());
        Output.printInitMessage(users.getUserNames());

    }

    private void initPlayer(Player player) {
        player.addSeveralCard(cardGenerator.getSeveralCard(STARTING_CARD_COUNT));
    }

    private void initUsers(List<Player> users) {
        for (Player user : users) {
            initPlayer(user);
        }
    }

    private void startGameLogic(Player dealer, Players users) {
        Output.printDealerFirstCardName(dealer.getName(), dealer.getCardNames().get(FIRST_CARD_INDEX));
        showUsersCardNames(users);
    }

    private void showUsersCardNames(Players users) {
        for (Player user : users.getUser()) {
            Output.printCardNames(user);
        }
    }

    private void progressPlayersTurnLogic(Player dealer, Players users) {
        doUsersTurn(users);
        doDealerTurn(dealer);
    }

    private void doUsersTurn(Players users) {
        for (Player user : users.getUser()) {
            doUserTurn(user);
        }
    }

    private void doDealerTurn(Player dealer) {
        while (dealer.canReceiveCard()) {
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
            showUserCardNames(user);
            return true;
        }

        return false;
    }

    private void showUserCardNames(Player user){
        user.addCard(cardGenerator.getOneCard());
        Output.printCardNames(user);
    }

    private void showPlayersCardInformationLogic(Player dealer, Players users) {
        Output.printPlayerCardInformation(dealer);
        showUsersCardInformation(users);
    }

    private void showUsersCardInformation(Players users) {
        for (Player user : users.getUser()) {
            Output.printPlayerCardInformation(user);
        }
    }

}
