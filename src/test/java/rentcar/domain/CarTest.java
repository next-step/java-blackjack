package rentcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차_생성_테스트")
    @Test
    void createRentCarTest() {
        Car Sonata = new Sonata(150);
        Car K5 = new K5(260);
        Car Avante = new Avante(300);
        assertAll(
            () -> assertThat(Sonata.getChargeQuantity()).isEqualTo(15),
            () -> assertThat(K5.getChargeQuantity()).isEqualTo(20),
            () -> assertThat(Avante.getChargeQuantity()).isEqualTo(20)
        );
    }
}