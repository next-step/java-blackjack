package blackjack.model;

public class User extends Player {

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

    @Override
    public void drawCard(Card card) {
        super.drawCard(card);
    }

}
