package blackjack.model.state;

import blackjack.model.BunchOfCard;
import blackjack.model.Card;

public interface State {
    State draw(Card card);

    State stay();

    boolean isFinished();

    BunchOfCard getBunchOfCard();

    double profit(double betMoney);
}
