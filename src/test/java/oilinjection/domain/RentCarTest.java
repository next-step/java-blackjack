package oilinjection.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import oilinjection.domain.car.Avante;
import oilinjection.domain.car.Car;
import oilinjection.domain.car.K5;
import oilinjection.domain.car.Sonata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RentCarTest {

    @DisplayName("Avante를 반환한다.")
    @Test
    void 아반떼_생성() {
        final Car avante = RentCar.rent("avante", 200D);
        assertThat(avante).isEqualTo(new Avante(200D));
    }

    @DisplayName("K5 반환한다.")
    @Test
    void K5_생성() {
        final Car k5 = RentCar.rent("K5", 200D);
        assertThat(k5).isEqualTo(new K5(200D));
    }

    @DisplayName("Sonata를 반환한다.")
    @Test
    void 소나타_생성() {
        final Car sonata = RentCar.rent("sonata", 200D);
        assertThat(sonata).isEqualTo(new Sonata(200D));
    }

    @DisplayName("해당하는 차종이 없으면 예외를 발생시킨다.")
    @Test
    void 차종_없음() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RentCar.rent("none", 10D));
    }

    @DisplayName("예약 하는 여행 거리가 최소 거리(1) 보다 작으면 예외가 발생한다.")
    @Test
    void 최소_거리보다_작음() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> RentCar.rent("avante", 0D));
    }

    @DisplayName("자동차의 차종은 대소문자를 구분하지 않는다.")
    @ValueSource(strings = {"Sonata", "sOnAtA", "SONATA"})
    @ParameterizedTest
    void 소나타_대소문자_구분없이_생성(final String name) {
        final Car sonata = RentCar.rent(name, 200D);
        assertThat(sonata).isEqualTo(new Sonata(200D));
    }
}
