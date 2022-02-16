package blackJack.domain;

import java.util.List;

public interface User {

    List<Card> getDeck();

    String getName();

    void appendToDeck(Card card);

    void appendToDeck(List<Card> cards);
}
