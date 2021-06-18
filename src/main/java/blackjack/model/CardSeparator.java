package blackjack.model;

public class CardSeparator {
    private static final CardGenerator cardGenerator = new CardGenerator();
    private static final int INITIAL_CARD_COUNT = 2;
    private static final int DEALER_CARD_RECEIVE_COUNT = 16;

    private CardSeparator() {
    }

    public static BunchOfCard drawInitialCard() {
        return cardGenerator.getSeveralCard(INITIAL_CARD_COUNT);
    }

    public static boolean canDealerReceiveCard(Dealer dealer) {
        return dealer.getCardValueSum() <= DEALER_CARD_RECEIVE_COUNT;
    }

    public static Card drawCard() {
        return cardGenerator.getOneCard();
    }

    public static boolean canUserReceiveCard(User user) {
        return !user.getState().isFinished();
    }
}
