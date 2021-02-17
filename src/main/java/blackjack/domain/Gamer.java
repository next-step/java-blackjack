package blackjack.domain;

public class Gamer extends Player {

    private final String name;
    private static final String CARD = "카드: ";
    public Gamer(String name, Deck deck) {
        super(deck);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
            .append(name)
            .append(CARD)
            .append(
                getCards().toString()
            ).toString();
    }

    public void getMoreCard(String answer) {
        if (answer.equals("y")) {
            addCard(deck.popCard());
        }
    }
}
