package blackjack.domain;

import java.util.List;

public interface GameParticipant {
    void hit(Card card);

    List<Card> getCardsBeforeGameStart();

    String getName();

    List<Card> getCards();

    int getResult();
}
