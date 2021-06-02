package blackjack;

import java.util.List;

public interface Player {
    void addCard(Card card);

    void addSeveralCard(List<Card> cards);

    int getCardValueSum();

    List<String> getCardNames();
}