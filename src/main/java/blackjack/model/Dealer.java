package blackjack.model;

import blackjack.model.Job;

public class Dealer implements Player {
    private final Pocket pocket = new Pocket();
    private final Deck deck;
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

    //TODO : 밖에서 안 쓰이면, 지워도 된다.
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
    public int getCardsScore() {
        int totalScore = 0;

        for(final Card card : pocket.getCards()){
            totalScore += card.getScore();
        }

        if(hasAce() && totalScore < 11){
            totalScore += 10;
        }

        return totalScore;
    }

    @Override
    public boolean hasAce(){
        return pocket.getCards()
                .stream()
                .anyMatch(card-> card.getValue()==CardValue.ONE);
    }
}