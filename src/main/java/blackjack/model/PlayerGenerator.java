package blackjack.model;

import blackjack.model.state.BlackJack;
import blackjack.model.state.Hit;

import java.util.List;

public class PlayerGenerator {

    private PlayerGenerator() {
    }

    public static Dealer makeDealer() {
        BunchOfCard bunchOfCard = CardSeparator.drawInitialCard();

        if (bunchOfCard.isBlackJack()) {
            return new Dealer(new BlackJack(bunchOfCard));
        }

        return new Dealer(new Hit(bunchOfCard));
    }

    public static Users makeUsers(List<String> userNames) {
        Users users = new Users();

        for (String name : userNames) {
            users.addUser(makeUser(name));
        }

        return users;
    }

    private static User makeUser(String Username) {
        BunchOfCard bunchOfCard = CardSeparator.drawInitialCard();

        if (bunchOfCard.isBlackJack()) {
            return new User(Username, new BlackJack(bunchOfCard));
        }

        return new User(Username, new Hit(bunchOfCard));
    }
}
