package blackjack.model;

import blackjack.utils.StringUtils;

public class User extends Player {
    private boolean win = false;
    private static final String RESULT_STRING_FORMAT = "%s: %s";

    private User(CardBundle cardHand, String name) {
        super(cardHand, name);
    }

    public User(String name) {
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
        if(win){
            return String.format(RESULT_STRING_FORMAT,name,StringUtils.WIN);
        }
        return String.format(RESULT_STRING_FORMAT,name,StringUtils.LOSE);
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder(super.toString());
        cardHand.getCards().forEach(card -> userString.append(card.toString()));
        return userString.toString();
    }
}
