package blackjack.domain;

public class Dealer extends Participant{

    public Dealer(String name) {
        super(name);
    }

    @Override
    void drawCard(int number) {
        if(cards.sumCardScore() > 17)
            return;

        // for문 - number
        //this.cards.add(Card.random());
    }
}
