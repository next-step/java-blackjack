package fuelInjection.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SonataTest {
    @DisplayName("`Sonata` String Type 이름을 가져야한다.")
    @Test
    public void givenSonataClass_whenCreateInstance_thenInstanceNameIsSonata () {
        Sonata sonata = new Sonata();

        assertThat(sonata.getName())
            .isEqualTo("Sonata");
    }

    @DisplayName("`10km/리터`의 연비 가져야한다.")
    @Test
    public void givenSonataClass_whenCreateInstance_thenDistancePerLiterIs10 () {
        Sonata sonata = new Sonata();

        assertThat(sonata.getDistancePerLiter())
            .isEqualTo(10);
    }
}