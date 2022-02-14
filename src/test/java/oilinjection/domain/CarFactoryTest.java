package oilinjection.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import oilinjection.domain.car.Avante;
import oilinjection.domain.car.Car;
import oilinjection.domain.car.K5;
import oilinjection.domain.car.Sonata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @DisplayName("Avante를 반환한다.")
    @Test
    void 아반떼_생성() {
        final Car avante = CarFactory.create("avante", 200D);
        assertThat(avante).isEqualTo(new Avante(200D));
    }

    @DisplayName("K5 반환한다.")
    @Test
    void K5_생성() {
        final Car k5 = CarFactory.create("K5", 200D);
        assertThat(k5).isEqualTo(new K5(200D));
    }

    @DisplayName("Sonata를 반환한다.")
    @Test
    void 소나타_생성() {
        final Car sonata = CarFactory.create("sonata", 200D);
        assertThat(sonata).isEqualTo(new Sonata(200D));
    }

    @DisplayName("해당하는 이름이 없으면 예외를 발생시킨다.")
    @Test
    void 이름_없음() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> CarFactory.create("none", 00D));
    }
}
