package blackJack.domain;

public interface User {

    final Deck deck = Deck.create();
    final UserName userName = UserName.from("");

    public default Deck getDeck() {
        return deck;
    };

    public default UserName getUserName() {
        return userName;
    };

    public default void appendToDeck(Card card) {
        deck.append(card);
    };
}
