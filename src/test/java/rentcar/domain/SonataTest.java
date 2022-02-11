package rentcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SonataTest {

    @ValueSource(ints = {150,200,300,400})
    @ParameterizedTest
    @DisplayName("Sonata는 연비는 10km/리터 이다")
    void testSonataDistancePerLiter(final double number){
        assertThat(new Sonata(number).getDistancePerLiter())
            .isEqualTo(10.0);
    }

    @ValueSource(ints = {150,200,300,400})
    @ParameterizedTest
    void testSonataTripDistance(final double number){
        assertThat(new Sonata(number).getTripDistance())
            .isEqualTo(number);
    }

    @Test
    void testSonataName() {
        //given
        final double distance = 150;
        assertThat(new Sonata(distance).getName())
            .isEqualTo("Sonata");
    }
}