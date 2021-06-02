package blackjack;

import java.util.List;

public interface Player {
    void addCard(Card card);
    int getCardValueSum();
    List<String> getCardNames();
}