package blackjack.model.state;

import blackjack.model.BunchOfCard;
import blackjack.model.Card;

public abstract class Finished extends Started {
    private static final String CAN_NOT_DRAW_MESSAGE = "게임이 종료되어 카드를 뽑을 수 없습니다.";
    private static final String CAN_NOT_STAY_MESSAGE = "게임이 종료되어 Stay 할 수 없습니다.";

    protected Finished(BunchOfCard bunchOfCard) {
        super(bunchOfCard);
    }

    abstract double earningRate();

    @Override
    public State draw(Card card) {
        throw new IllegalArgumentException(CAN_NOT_DRAW_MESSAGE);
    }

    @Override
    public State stay() {
        throw new IllegalArgumentException(CAN_NOT_STAY_MESSAGE);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public double profit(double betMoney) {
        return 1 * earningRate();
    }
}
