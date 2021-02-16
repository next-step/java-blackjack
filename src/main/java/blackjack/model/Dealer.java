package blackjack.model;

public class Dealer implements Player {
    private final Deck deck;
    private final Pocket pocket = new Pocket();
    private final String name = "Dealer";
    private final Job job = Job.DEALER;

    public Dealer(final Deck deck) {
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

    @Override
    public Job getJob() {
        return job;
    }

    @Override
    public String exportCardStats() {
        return getName() + " : " + pocket.getCardsName();
    }

    @Override
    public int getTotalScore() {
        return pocket.getTotalScore();
    }

    @Override
    public boolean hasAce() {
        return pocket.hasAce();
    }
}