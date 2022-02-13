package oilinjection.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class K5Test {

    @DisplayName("K5의 주입해야할 연료량을 구한다.")
    @Test
    void K5_필요한_연료량() {
        final Car k5 = new K5(260D);
        assertThat(k5.getChargeQuantity()).isEqualTo(20D);
    }
}
