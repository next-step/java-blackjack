package blackjack.controller;

import blackjack.model.CardGenerator;
import blackjack.model.Player;
import blackjack.model.PlayerFactory;
import blackjack.model.Players;
import blackjack.view.Input;
import blackjack.view.Output;

import java.util.Arrays;
import java.util.List;

public class BlackJackController {
    public static final int BURST_COUNT = 21;
    private static final int FIRST_CARD_INDEX = 0;
    private static final int STARTING_CARD_COUNT = 2;
    private static final int HAVE_COUNT = 0;
    private static final String SPLIT_SEPARATOR = ",";
    private static final String GET_RECEIVE_CARD = "y";
    private static final String WINNING_STATE_SEPARATOR = ": ";
    private static final String WIN = "승 ";
    private static final String LOSE = "패 ";
    private static final CardGenerator cardGenerator = new CardGenerator();

    public void blankJackStart() {
        Player dealer = PlayerFactory.of(PlayerFactory.DEALER);
        List<String> userNames = Arrays.asList(Input.inputNames().split(SPLIT_SEPARATOR));
        Players users = new Players(userNames);

        doInitialLogic(dealer, users);
        doPlayersInitialPrintLogic(dealer, users);
        doPlayersTurnLogic(dealer, users);
        doPlayersCardInformationPrintLogic(dealer, users);
        doMakeWinningStateLogic(dealer, users);
        doMakeResultLogic(dealer, users);
    }

    private void doInitialLogic(Player dealer, Players users) {
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

    private void doPlayersInitialPrintLogic(Player dealer, Players users) {
        Output.printDealerFirstCardName(dealer.getName(), dealer.getCardNames().get(FIRST_CARD_INDEX));
        printUsersCardNames(users);
    }

    private void printUsersCardNames(Players users) {
        for (Player user : users.getUser()) {
            Output.printCardNames(user.getName(), user.getCardNames());
        }
    }

    private void doPlayersTurnLogic(Player dealer, Players users) {
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
            user.addCard(cardGenerator.getOneCard());
            Output.printCardNames(user.getName(), user.getCardNames());
            return true;
        }

        return false;
    }

    private void doPlayersCardInformationPrintLogic(Player dealer, Players users) {
        Output.printPlayerCardInformation(dealer);
        printUsersCardInformation(users);
    }

    private void printUsersCardInformation(Players users) {
        for (Player user : users.getUser()) {
            Output.printPlayerCardInformation(user);
        }
    }

    private void doMakeWinningStateLogic(Player dealer, Players users) {
        for (Player user : users.getUser()) {
            makeWinningState(dealer, user);
        }
    }

    private void makeWinningState(Player dealer, Player user) {
        if (isDealerBurst(dealer)) {
            dealerLoseLogic(dealer, user);
            return;
        }

        if (isUserBurst(user)) {
            userLoseLogic(dealer, user);
            return;
        }

        comparePlayersLogic(dealer, user);
    }

    private boolean isDealerBurst(Player dealer) {
        return burstCheck(dealer);
    }

    private boolean isUserBurst(Player user) {
        return burstCheck(user);
    }

    private void dealerLoseLogic(Player dealer, Player user) {
        if (!burstCheck(user)) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
    }

    private void userLoseLogic(Player dealer, Player user) {
        dealer.getWinningState().plusWinCount();
        user.getWinningState().plusLoseCount();
    }

    private void comparePlayersLogic(Player dealer, Player user) {
        if (dealer.getCardValueSum() > user.getCardValueSum()) {
            dealer.getWinningState().plusWinCount();
            user.getWinningState().plusLoseCount();
        }
        if (dealer.getCardValueSum() < user.getCardValueSum()) {
            dealer.getWinningState().plusLoseCount();
            user.getWinningState().plusWinCount();
        }
    }

    private boolean burstCheck(Player player) {
        return player.getCardValueSum() > BURST_COUNT;
    }


    private void doMakeResultLogic(Player dealer, Players users) {
        String result = makeResult(dealer, users.getUser());
        Output.printResult(result);
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

    private StringBuilder makeUserResult(Player user) {
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
