package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;

public interface Gameable {

    Cards cards();

    void addCard(Card card);

    boolean isEnd();

    Gameable judge();
}