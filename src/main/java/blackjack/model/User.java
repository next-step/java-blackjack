package blackjack.model;

import static blackjack.utils.StringUtils.LOSE;
import static blackjack.utils.StringUtils.WIN;

public class User extends Player {
    private static final String RESULT_STRING_FORMAT = "%s: %s";
    private boolean win = false;

    private User(String name) {
        super(name);
    }

    private User(String name, Money money) {
        super(name);
        this.money = money;
    }

    public static User of(String name) {
        return new User(name);
    }
    public static User of(String name,Money money) {
        return new User(name,money);
    }


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Money getMoney() {
        return money;
    }

    @Override
    public String getResult() {
        if(win){
            return String.format(RESULT_STRING_FORMAT,name,WIN);
        }
        return String.format(RESULT_STRING_FORMAT,name,LOSE);
    }

    @Override
    public String toString() {
        StringBuilder userString = new StringBuilder(super.toString());
        cardHand.getCards().forEach(card -> userString.append(card.toString()));
        return userString.toString();
    }
}
