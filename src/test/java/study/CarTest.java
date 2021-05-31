package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class CarTest {
    @Test
    public void 이동() {
        Car car = new Car("chloe", 0);
        Car actual = car.move(() -> true);

        assertThat(actual.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지() {
        Car car = new Car("chloe", 0);
        Car actual = car.move(new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });

        assertThat(actual.getPosition()).isEqualTo(0);
    }
}
