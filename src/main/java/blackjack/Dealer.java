package blackjack;

public class Dealer implements Player {
    private final Pocket pocket = new Pocket();
    private final Deck deck;
    private final String name;

    public Dealer(final String name, final Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    @Override
    public void receiveCard() {
        final Card card = deck.getCard();
        pocket.add(card);
    }

    @Override
    public Pocket getCardStats() {
        return pocket;
    }

    @Override
    public String getName() {
        return name;
    }

    public String exportCardStats() {
        return getName() + " : " + pocket.getCardsName();
    }
}