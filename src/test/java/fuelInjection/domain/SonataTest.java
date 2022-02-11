package fuelInjection.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SonataTest {
    int TEMP_DISTANCE = 10;

    @DisplayName("`Sonata` String Type 이름을 가져야한다.")
    @Test
    public void givenSonataClass_whenCreateInstance_thenInstanceNameIsSonata () {
        Sonata sonata = new Sonata(TEMP_DISTANCE);

        assertThat(sonata.getName())
            .isEqualTo("Sonata");
    }

    @DisplayName("`10km/리터`의 연비 가져야한다.")
    @Test
    public void givenSonataClass_whenCreateInstance_thenDistancePerLiterIs10 () {
        Sonata sonata = new Sonata(TEMP_DISTANCE);

        assertThat(sonata.getDistancePerLiter())
            .isEqualTo(10);
    }

    @DisplayName("거리 가져야한다.")
    @ParameterizedTest
    @ValueSource(ints = {10, 30, 100})
    public void givenTripDistanceOverZeroTypeWithInt_whenGetTripDistance_thenNotThrowException (int tripDistance) {
        Sonata sonata = new Sonata(tripDistance);

        assertThat(sonata.getTripDistance())
            .isEqualTo(tripDistance);
    }

    @DisplayName("0이하 정수 값이 TripDistanceUnder으로 주어졌을때, IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10, -100})
    public void givenTripDistanceBelowZeroTypeWithInt_whenGetTripDistance_thenThrowIllegalArgumentException (int tripDistance) {
        assertThatThrownBy(() -> new Sonata(tripDistance))
            .isInstanceOf(IllegalArgumentException.class);
    }
}