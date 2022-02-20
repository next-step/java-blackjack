package blackjack.domain;


public class Player extends Participant{

    public Player(String name) {
        super(name);
    }

    @Override
    public boolean drawCardMultiple(Deck deck, int number) {
        cards.addCards(deck.drawMultiple(number));
        return true;
    }
}
