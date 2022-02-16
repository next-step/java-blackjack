package blackjack.domain;

public class Dealer extends Participant{

    public Dealer(String name) {
        super(name);
    }

    @Override
    public Card drawCardMultiple(Deck deck, int number) {
        if(cards.sumCardScore() > 17)
            return null;

        // for문 - number
        //this.cards.add(Card.random());
        return null;
    }
}
