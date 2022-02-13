package oilinjection.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AvanteTest {

    @DisplayName("아반떼의 주입 해야할 연료량을 구한다.")
    @Test
    void 아반떼_필요한_연료량() {
        final Car avante = new Avante(300D);
        assertThat(avante.getChargeQuantity()).isEqualTo(20D);
    }
}
