package oilinjection.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SonataTest {

    @DisplayName("소나타의 주입해야할 연료량을 구한다.")
    @Test
    void 소나타_필요_연료량() {
        final Car sonata = new Sonata(200D);
        assertThat(sonata.getChargeQuantity()).isEqualTo(20D);
    }
}