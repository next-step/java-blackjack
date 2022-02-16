package blackjack.domain;


public class Player extends Participant{

    public Player(String name) {
        super(name);
    }

    @Override
    public Card drawCardMultiple(Deck deck, int number) {
        return null;
    }
}
