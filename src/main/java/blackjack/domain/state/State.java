package blackjack.domain.state;

import blackjack.domain.card.Cards;

public interface State {

    State draw(PlayingCard playingCard);

    State stay();

    boolean isFinished();

    Cards cards();
}
