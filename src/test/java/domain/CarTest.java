package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("이동거리로 주입해야할 연료량을 계산한다.")
    @Test
    public void getChargeQuantity() {
        //given
        final List<Double> FUELS = Arrays.asList(20.00, 15.00, 20.00);
        final List<Integer> DISTANCES = Arrays.asList(260, 150, 300);

        final List<Car> cars = new ArrayList<>();

        cars.add(new K5(DISTANCES.get(0)));
        cars.add(new Sonata(DISTANCES.get(1)));
        cars.add(new Avante(DISTANCES.get(2)));

        //when
        final List<Double> results = new ArrayList<>();

        for (Car car : cars) {
            results.add(car.getChargeQuantity());
        }

        //then
        assertThat(results).isEqualTo(FUELS);
    }
}