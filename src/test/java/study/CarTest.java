package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public void 이동() {
        final Car car = new Car("bin", 0);
        final Car actual = car.move(() -> true);
        assertThat(actual.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지() {
        final Car car = new Car("bin", 0);
        final Car actual =
                car.move(() -> false);
        assertThat(actual.getPosition()).isEqualTo(0);
    }
}