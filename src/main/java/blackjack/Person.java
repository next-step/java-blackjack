package blackjack;

public abstract class Person {

    private static final int INIT_CARD_COUNT = 2;

    protected final String userName;
    protected final Cards cards;

    public Person(String userName, Cards cards) {
        this.userName = userName;
        this.cards = cards;
    }

    public void drawCard(Deck deck) {
        cards.add(deck.drawCard());
    }

    public abstract boolean canDrawCard();

    public int cardSize() {
        return cards.size();
    }

    public void initializeDeck(Deck deck) {
        for (int i = 0; i < INIT_CARD_COUNT; i++) {
            cards.add(deck.drawCard());
        }
    }
}
