package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class CarTest {

    @Test
    void 이동() {
        final Car car = new Car("soyeon", 0);
        final Car actual = car.move(() -> true); /*new MoveStrategy() {
        람다를 사용하기 위해서는 모태가 되는 추상메소드는( interface ) 를 하나만 갖고있어야함. ->single apstract method
        @Override
        public boolean isMovable() {
            return true;
        }
    });*/
        Assertions.assertThat(actual.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        final Car car = new Car("soyeon", 0);
        final Car actual = car.move(() -> false);/*new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        });*/
        Assertions.assertThat(actual.getPosition()).isEqualTo(0);
    }
}
