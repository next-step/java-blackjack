package rentcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Sonata(150);
    }

    @Test
    void getDistancePerLiter() {
        assertThat(car.getDistancePerLiter()).isEqualTo(10);
    }

    @Test
    void getTripDistance() {
        assertThat(car.getTripDistance()).isEqualTo(150);
    }

    @Test
    void getName() {
        assertThat(car.getName()).isEqualTo("Sonata");
    }

    @Test
    void getChargeQuantity() {
        assertThat(car.getChargeQuantity()).isEqualTo(15);
    }
}