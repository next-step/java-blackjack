package blackjack.domain.state;

import blackjack.domain.card.Card;
import blackjack.domain.card.Cards;
import java.util.List;

public interface Gameable {

    Cards cards();

    void addCard(Card card);

    boolean isEnd();

    Gameable judge();

    List<Card> getCards();

    int getTotalScore();
}