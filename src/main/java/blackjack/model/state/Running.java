package blackjack.model.state;

import blackjack.model.BunchOfCard;

public abstract class Running extends Started {
    private static final String CAN_NOT_GET_PROFIT_MESSAGE = "진행 중에는 보상을 받을 수 없습니다.";

    protected Running(BunchOfCard bunchOfCard) {
        super(bunchOfCard);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double betMoney) {
        throw new IllegalArgumentException(CAN_NOT_GET_PROFIT_MESSAGE);
    }
}
