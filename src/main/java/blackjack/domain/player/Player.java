package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.state.Gameable;
import java.util.List;

public class Player extends Person {

    private final Gameable cards;

    public Player(final String name, final Gameable cards) {
        super(name);
        this.cards = cards;
    }

    public Gameable getCar경ds() {
        return cards;
    }

    public Gameable getCards() {
        return cards;
    }

    public List<Card> getPlayerCard(){
        return cards.getCards();
    }

    public int getPlayerScore(){
        return cards.getTotalScore();
    }
}
