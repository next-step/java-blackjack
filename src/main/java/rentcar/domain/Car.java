package rentcar.domain;

import static rentcar.util.Constant.UNIT;
import static rentcar.util.Constant.DELIMITER;

import java.math.BigDecimal;

public abstract class Car {

    /**
     * 리터당 이동 거리. 즉, 연비
     */
    abstract double getDistancePerLiter();

    /**
     * 여행하려는 거리
     */
    abstract double getTripDistance();

    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    @Override
    public String toString() {
        return getName() + DELIMITER + BigDecimal.valueOf(getChargeQuantity()).stripTrailingZeros().toPlainString() + UNIT;
    }


}
