package fuelInjection.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class AvanteTest {
    int TEMP_DISTANCE = 10;

    @DisplayName("`Avante` String Type 이름을 가져야한다.")
    @Test
    public void givenSonataClass_whenCreateInstance_thenInstanceNameIsSonata () {
        Avante avante = new Avante(TEMP_DISTANCE);

        assertThat(avante.getName())
            .isEqualTo("Avante");
    }

    @DisplayName("`15km/리터`의 연비 가져야한다.")
    @Test
    public void givenSonataClass_whenCreateInstance_thenDistancePerLiterIs10 () {
        Avante avante = new Avante(TEMP_DISTANCE);

        assertThat(avante.getDistancePerLiter())
            .isEqualTo(15);
    }

    @DisplayName("거리 가져야한다.")
    @ParameterizedTest
    @ValueSource(doubles = {0, 10, 30, 100, 1.5})
    public void givenTripDistanceOverZeroTypeWithDouble_whenGetTripDistance_thenNotThrowException (double tripDistance) {
        Avante avante = new Avante(tripDistance);

        assertThat(avante.getTripDistance())
            .isEqualTo(tripDistance);
    }

    @DisplayName("0이하 정수 값이 TripDistanceUnder으로 주어졌을때, IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(doubles = {-1, -10, -100})
    public void givenTripDistanceBelowZeroTypeWithDouble_whenGetTripDistance_thenThrowIllegalArgumentException (double tripDistance) {
        assertThatThrownBy(() -> new Avante(tripDistance))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateTripDistanceAndChargeQuantity() {
        return Stream.of(
            Arguments.of(0, 0),
            Arguments.of(15, 1),
            Arguments.of(150, 10),
            Arguments.of(1500, 100)
        );
    }

    @DisplayName("주입해야할 연료량을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("generateTripDistanceAndChargeQuantity")
    public void givenTripDistanceOverZeroTypeWithDouble_whenGetChargeQuantity_thenCanCalculateChargeQuantity (double tripDistance, double chargeQuantity) {
        assertThat(new Avante(tripDistance).getChargeQuantity())
            .isEqualTo(chargeQuantity);
    }
}