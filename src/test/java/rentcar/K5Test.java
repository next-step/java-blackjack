package rentcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class K5Test {

    @Test
    @DisplayName("K5의 리터당 이동 거리를 구하는 테스트")
    void K5의_리터당_이동거리_출력() {
        final Car car = new K5(100);
        final double distancePerLiter = car.getDistancePerLiter();
        assertThat(distancePerLiter).isEqualTo(13);
    }

    @ParameterizedTest
    @ValueSource(doubles = {100.0, 200.0, 300.0, 400.0})
    @DisplayName("K5의 이동거리를 출력하는 테스트")
    void K5의_이동거리_출력(double distance) {
        final Car car = new K5(distance);
        final double tripDistance = car.getTripDistance();
        assertThat(tripDistance).isEqualTo(distance);
    }

    @Test
    @DisplayName("K5의 이름을 출력하는 테스트")
    void K5의_이름을_출력() {
        final Car car = new K5(100);
        final String name = car.getName();
        assertThat(name).isEqualTo("K5");
    }

    @Test
    @DisplayName("K5의 거리에 따른 연료량을 출력하는 테스트")
    void K5의_거리에_따른_연료량() {
        final Car car = new K5(100);
        double chargeQuantity = car.getChargeQuantity();
        assertThat(chargeQuantity).isEqualTo(10.0);
    }
}