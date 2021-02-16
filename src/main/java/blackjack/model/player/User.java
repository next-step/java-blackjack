package blackjack.model.player;

import blackjack.model.card.CardBundle;
import blackjack.utils.StringUtils;

public class User extends Player {
    private boolean win = false;

    private User(CardBundle cardHand, String name) {
        super(cardHand, name);
    }

    private User(String name) {
        super(name);
    }

    public static User of(CardBundle cardHand, String name) {
        return new User(cardHand, name);
    }

    public static User of(String name) {
        return new User(name);
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    @Override
    public String getResult() {
        if (win) {
            return String.format(StringUtils.USER_RESULT_STRING_FORMAT, name, StringUtils.WIN);
        }
        return String.format(StringUtils.USER_RESULT_STRING_FORMAT, name, StringUtils.LOSE);
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder(super.toString());
        cardHand.getCards().forEach(card -> userString.append(card.toString()));
        return userString.toString();
    }
}
