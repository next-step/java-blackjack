package rentcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class K5Test {
    @ValueSource(ints = {150,200,300,400})
    @ParameterizedTest
    @DisplayName("K5는 연비는 13km/리터 이다")
    void testK5DistancePerLiter(final double number){
        assertThat(new K5(number).getDistancePerLiter())
            .isEqualTo(13.0);
    }

    @ValueSource(ints = {150,200,300,400})
    @ParameterizedTest
    void testK5TripDistance(final double number){
        assertThat(new K5(number).getTripDistance())
            .isEqualTo(number);
    }

    @Test
    void testK5Name() {
        final double distance = 150;
        assertThat(new K5(distance).getName())
            .isEqualTo("K5");
    }
}
