package blackjack.domain;

public class Dealer extends Participant{

    public Dealer(String name) {
        super(name);
    }

    @Override
    public boolean drawCardMultiple(Deck deck, int number) {
        if(cards.sumCardScore() > 17) {
            return false;
        }
        cards.addCards(deck.drawMultiple(number));
        return true;
    }
}
