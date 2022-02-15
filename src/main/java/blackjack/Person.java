package blackjack;

public abstract class Person {

    private static final int INIT_CARD_COUNT = 2;

    protected final String userName;
    protected final Cards cards;
    protected final Score score;

    public Person(String userName, Cards cards) {
        this.userName = userName;
        this.cards = cards;
        this.score = new Score(0);

    }

    public abstract boolean canDrawCard();
}
