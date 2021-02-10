package blackjack.domain;

import java.util.List;

public interface GameParticipant {
    void addCard(Card card);

    List<Card> getCardsBeforeGameStart();

    String getName();

    List<Card> getCards();

    int getResult();
}
