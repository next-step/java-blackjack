package rentcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @DisplayName("소나타의 리터당 이동 거리를 구하고, 리터당 이동거리가 10인 지 확인하는 테스트")
    void 소나타의_리터당_이동거리_출력() {
        final Car car = new Sonata(100);
        final double distancePerLiter = car.getDistancePerLiter();
        assertThat(distancePerLiter).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {100.0, 200.0, 300.0, 400.0})
    @DisplayName("소나타의 이동거리를 출력하는 테스트")
    void 소나타의_이동거리_출력(double distance) {
        final Car car = new Sonata(distance);
        final double tripDistance = car.getTripDistance();
        assertThat(tripDistance).isEqualTo(distance);
    }

    @Test
    @DisplayName("소나타의 이름을 출력하는 테스트")
    void 소나타의_이름을_출력() {
        final Car car = new Sonata(100);
        final String name = car.getName();
        assertThat(name).isEqualTo("소나타");
    }

    @Test
    @DisplayName("소나타의 거리에 따른 연료량을 출력하는 테스트")
    void 소나타의_거리에_따른_연료량() {
        final Car car = new Sonata(100);
        double chargeQuantity = car.getChargeQuantity();
        assertThat(chargeQuantity).isEqualTo(10.0);
    }
}
