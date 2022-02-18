package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import java.util.List;

public abstract class CardSupport implements Gameable {

    Cards cards;

    public CardSupport(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }

    @Override
    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public List<Card> getCards() {
        return cards.getCards();
    }

    @Override
    public int getTotalScore() {
        return cards.sumScore();
    }

}
