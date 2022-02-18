package blackjack.domain.player;

import blackjack.domain.card.Card;
import blackjack.domain.state.Gameable;
import java.util.List;

public class Dealer extends Person {

    private final Gameable cards;

    public Dealer(String name, Gameable cards) {
        super(name);
        this.cards = cards;
    }

    public Gameable getCards() {
        return cards;
    }

    public List<Card> getDealerCard(){
        return cards.getCards();
    }

    public int getDealerScore(){
        return cards.getTotalScore();
    }
}
