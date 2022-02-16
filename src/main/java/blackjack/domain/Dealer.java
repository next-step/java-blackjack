package blackjack.domain;

public class Dealer extends Participant{

    public Dealer(String name) {
        super(name);
    }

    @Override
    public void drawCardMultiple(Deck deck, int number) {
        if(cards.sumCardScore() > 17) {
            return;
        }
        cards.addCards(deck.drawMultiple(number));
    }
}
