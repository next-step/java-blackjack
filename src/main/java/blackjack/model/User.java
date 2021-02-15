package blackjack.model;

import blackjack.utils.StringUtils;

public class User extends Player {
    public boolean win = false;

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

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getResult() {
        if(win){
            return StringUtils.WIN;
        }
        return StringUtils.LOSE;
    }
}
