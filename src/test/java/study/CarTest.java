package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    public void move() {
        final Car car = new Car("hyeonjin", 0);
//        final Car actual = car.move((a, b) -> {
//            return true;
//        });

        final Car actual = car.move(() -> true);

        assertThat(actual.getPosition()).isEqualTo(1);
    }

    @Test
    public void stop() {
        final Car car = new Car("hyeonjin", 0);
        final Car actual = car.move(() -> false);
        assertThat(actual.getPosition()).isEqualTo(0);
    }
}
