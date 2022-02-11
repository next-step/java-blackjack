package rentcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AvanteTest {

    @ValueSource(ints = {150,200,300,400})
    @ParameterizedTest
    @DisplayName("Avante는 연비는 15km/리터 이다")
    void testAvanteDistancePerLiter(final double number){
        assertThat(new Avante(number).getDistancePerLiter())
            .isEqualTo(15.0);
    }

    @ValueSource(ints = {150,200,300,400})
    @ParameterizedTest
    void testAvanteTripDistance(final double number){
        assertThat(new Avante(number).getTripDistance())
            .isEqualTo(number);
    }

    @Test
    void testAvanteName() {
        final double distance = 150;
        assertThat(new Avante(distance).getName())
            .isEqualTo("Avante");
    }
}
