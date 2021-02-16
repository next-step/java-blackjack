package blackjack.domain.state;

import blackjack.domain.card.Cards;
import blackjack.domain.card.PlayingCard;

public interface State {

    State draw(PlayingCard playingCard);

    State stay();

    boolean isFinished();

    Cards cards();
}
