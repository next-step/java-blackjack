package blackjack.model.player;

import blackjack.model.card.CardBundle;
import blackjack.utils.StringUtils;

public class Dealer extends Player {
    public static final int UPPER_BOUND_TO_DRAW = 16;
    private int winningCount = 0;
    private int losingCount = 0;

    private Dealer(CardBundle cardHand, String name) {
        super(cardHand, name);
    }

    private Dealer(String name) {
        super(name);
    }

    public static Dealer of(CardBundle cardHand, String name) {
        return new Dealer(cardHand, name);
    }

    public static Dealer of(String name) {
        return new Dealer(name);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getLosingCount() {
        return losingCount;
    }

    public void increaseWinningCount() {
        this.winningCount++;
    }

    public void increaseLosingCount() {
        this.losingCount++;
    }

    @Override
    public String getResult() {
        return String.format(StringUtils.DEALER_RESULT_STRING_FORMAT,
                name, winningCount, StringUtils.WIN, losingCount, StringUtils.LOSE);
    }

    @Override
    public String toString() {
        return super.toString() + cardHand.getCards().get(0).toString();
    }
}
