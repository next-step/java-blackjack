package rentCompany.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AvanteTest {

    static Car avante;

    @BeforeAll
    static void setup() {
        avante = new Avante(150);
    }

    @DisplayName("리터당 이동 거리(연비)를 가져온다.")
    @Test
    void testGetDistancePerLiter() {
        double given = avante.getDistancePerLiter();
        assertThat(given).isEqualTo(10);
    }

    @DisplayName("여행하려는 거리를 가져온다.")
    @Test
    void testGetTripDistance() {
        double given = avante.getTripDistance();
        assertThat(given).isEqualTo(150);
    }

    @DisplayName("차종의 이름을 가져온다.")
    @Test
    void testGetName() {
        String given = avante.getName();
        assertThat(given).isEqualTo("Avante");
    }
}