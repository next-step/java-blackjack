package blackjack.domain;

import java.util.List;

public interface CardAddible {

    List<Card> cards();

    void addCard(Card card);

    int getTotalScore();
}