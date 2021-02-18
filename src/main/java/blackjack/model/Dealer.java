package blackjack.model;

import blackjack.utils.StringUtils;

public class Dealer extends Player{

    public static final int UPPER_BOUND_TO_DRAW = 16;
    private static final String RESULT_STRING_FORMAT = "%s: %d%s %d%s";
    private int winningCount = 0;
    private int losingCount = 0;

    private Dealer(CardBundle cardHand, String name) {
        super(cardHand, name);
    }

    public Dealer(String name) {
        super(name);
    }

    public static Dealer of(CardBundle cardHand, String name) {
        return new Dealer(cardHand,name);
    }

    public static Dealer of(String name) {
        return new Dealer(name);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public void setWinningCount(int winningCount) {
        this.winningCount = winningCount;
    }

    public int getLosingCount() {
        return losingCount;
    }

    public void setLosingCount(int losingCount) {
        this.losingCount = losingCount;
    }

    @Override
    public String getResult(){
        return String.format(RESULT_STRING_FORMAT,
                name,
                winningCount, StringUtils.WIN,
                losingCount, StringUtils.LOSE);
    }

    @Override
    public String toString() {
        StringBuilder dealerString = new StringBuilder(super.toString());
        cardHand.getCards().forEach(card -> dealerString.append(card.toString()));
        return dealerString.toString();
    }

    public String showOnlyOneCard() {
        StringBuilder dealerString = new StringBuilder(super.toString());
        dealerString.append(cardHand.getCards().get(0).toString());
        return dealerString.toString();
    }
}
