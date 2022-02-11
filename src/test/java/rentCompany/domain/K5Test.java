package rentCompany.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class K5Test {

    static Car K5;

    @BeforeAll
    static void setup() {
        K5= new K5(260);
    }

    @DisplayName("리터당 이동 거리(연비)를 가져온다.")
    @Test
    void testGetDistancePerLiter() {
        double given = K5.getDistancePerLiter();
        assertThat(given).isEqualTo(20);
    }

    @DisplayName("여행하려는 거리를 가져온다.")
    @Test
    void testGetTripDistance() {
        double given = K5.getTripDistance();
        assertThat(given).isEqualTo(260);
    }

    @DisplayName("차종의 이름을 가져온다.")
    @Test
    void testGetName() {
        String given = K5.getName();
        assertThat(given).isEqualTo("K5");
    }
}