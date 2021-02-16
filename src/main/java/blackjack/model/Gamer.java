package blackjack.model;

public class Gamer implements Player {
    private final Pocket pocket = new Pocket();
    private final Deck deck;

    private final String name;
    private final Job job = Job.GAMER;

    public Gamer(final String name, final Deck deck) {
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
    public Job getJob() {
        return job;
    }

    @Override
    public String getName() {
        return name;
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
        return pocket.getCards()
                .stream()
                .anyMatch(card -> card.getValue() == CardValue.ACE);
    }
}