package rentcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private static final Map<String, Car> CARS = new HashMap<>();

    @BeforeAll
    static void beforeAll() {
        CARS.put("Sonata", new Sonata(100));
        CARS.put("Avante", new Avante(200));
        CARS.put("K5", new K5(300));
    }

    @DisplayName("자동차들의 리터당 이동거리를 출력하는 테스트")
    @ParameterizedTest(name = "{index} => 자동차: {0}, 리터당 이동거리: {1}")
    @CsvSource({"Sonata, 10", "Avante, 15", "K5, 13"})
    void 자동차들의_리터당_이동거리_출력(String inputCarName, int inputDistancePerLiter) {
        final Car car = CARS.get(inputCarName);
        final double distancePerLiter = car.getDistancePerLiter();
        assertThat(distancePerLiter).isEqualTo(inputDistancePerLiter);
    }

    @DisplayName("자동차들의 이동거리를 출력하는 테스트")
    @ParameterizedTest(name = "{index} => 자동차: {0}, 이동거리: {1}")
    @CsvSource({"Sonata, 100", "Avante, 200", "K5, 300"})
    void 자동차들의_이동거리_출력(String inputCarName, int inputTripDistance) {
        final Car car = CARS.get(inputCarName);
        final double tripDistance = car.getTripDistance();
        assertThat(tripDistance).isEqualTo(inputTripDistance);
    }

    @DisplayName("자동차들의 이름을 출력하는 테스트")
    @ParameterizedTest(name = "{index} => 자동차 {0}, 이름: {1}")
    @CsvSource({"Sonata, 소나타", "Avante, 아반떼", "K5, K5"})
    void 자동차들의_이름을_출력(String inputCarName, String inputCarDisplayName) {
        final Car car = CARS.get(inputCarName);
        final String carName = car.getName();
        assertThat(carName).isEqualTo(inputCarDisplayName);
    }

    @DisplayName("자동차들의 거리에 따른 연료량을 출력하는 테스트")
    @ParameterizedTest(name = "{index} -> 자동차 {0}, 연료량: {1}")
    @CsvSource({"Sonata, 10.00", "Avante, 13.33", "K5, 23.08"})
    void 자동차들의_거리에_따른_연료량_출력(String inputCarName, double inputChargeQuantity) {
        final Car car = CARS.get(inputCarName);
        double chargeQuantity = car.getChargeQuantity();
        assertThat(chargeQuantity).isEqualTo(inputChargeQuantity);
    }
}