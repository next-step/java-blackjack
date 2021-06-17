package blackjack.model;

import blackjack.view.Input;
import blackjack.view.Output;

public class CardSeparator {
    private static final CardGenerator cardGenerator = new CardGenerator();
    private static final int INITIAL_CARD_COUNT = 2;
    private static final int DEALER_CARD_RECEIVE_COUNT = 16;
    private static final String GET_RECEIVE_CARD = "y";

    private CardSeparator() {
    }

    public static BunchOfCard drawInitialCard() {
        return cardGenerator.getSeveralCard2(INITIAL_CARD_COUNT);
    }

    public static boolean canDealerReceiveCard(Dealer dealer) {
        return dealer.getCardValueSum() <= DEALER_CARD_RECEIVE_COUNT;
    }

    public static boolean canUserReceiveCard(User user) {
        return user.getCardValueSum() <= 21;
    }

    public static void doUsersTurn(Users users) {
        for (User user : users.getUsers()) {
            doUserTurn(user);
        }
    }

    public static void doDealerTurn(Dealer dealer) {
        while (canDealerReceiveCard(dealer)) {
            dealer.drawCard(cardGenerator.getOneCard());
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
            user.drawCard(cardGenerator.getOneCard());
            Output.printCardNames(user.getName(), user.getCardNames());
            return true;
        }

        return false;
    }
}
