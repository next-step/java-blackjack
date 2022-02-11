package fuelInjection.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    @ValueSource(ints = {10 ,20 ,30})
    public void givenValidDistance_whenGetTripDistance_thenNotThrowException (int tripDistance) {
        Sonata sonata = new Sonata(tripDistance);

        assertThat(sonata.getTripDistance())
            .isEqualTo(tripDistance);
    }

    @DisplayName("거리 가져야한다.")
    @ParameterizedTest
    @ValueSource(ints = {0 ,-1 ,-2})
    public void givenInvalidDistance_whenGetTripDistance_thenThrowException (int tripDistance) {
        Sonata sonata = new Sonata(tripDistance);

        assertThatThrownBy(() -> sonata.getTripDistance())
            .isInstanceOf(IllegalArgumentException.class);
    }
}