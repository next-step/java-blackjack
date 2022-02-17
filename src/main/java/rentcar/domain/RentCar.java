package rentcar.domain;

import static rentcar.util.Constant.UNIT;
import static rentcar.util.Constant.DELIMITER;

import java.math.BigDecimal;

public abstract class RentCar implements Car {

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return getTripDistance() / getDistancePerLiter();
    }

    @Override
    public String toString() {
        return getName() + DELIMITER + BigDecimal.valueOf(getChargeQuantity()).stripTrailingZeros()
            .toPlainString() + UNIT;
    }

}
