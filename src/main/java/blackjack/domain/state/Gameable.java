package blackjack.domain.state;

import blackjack.domain.card.Cards;

public interface Gameable {


    boolean isEnd();

    Cards cards();

    Gameable stay();

    Gameable draw();

}