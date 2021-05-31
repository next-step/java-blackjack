package rentCompany;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {
    @Test
    void createK5() {
        Car k5 = new K5();

        assertAll(
                () -> assertThat(k5.getName()).isEqualTo("K5"),
                () -> assertThat(k5.getDistance()).isEqualTo(100),
                () -> assertThat(k5.getFuelEfficiency()).isEqualTo(13)
        );
    }

    @Test
    void createSonata() {
        Car sonata = new Sonata();

        assertAll(
                () -> assertThat(sonata.getName()).isEqualTo("sonata"),
                () -> assertThat(sonata.getDistance()).isEqualTo(100),
                () -> assertThat(sonata.getFuelEfficiency()).isEqualTo(10)
        );
    }

    @Test
    void createAvante() {
        Car avante = new Avante();

        assertAll(
                () -> assertThat(avante.getName()).isEqualTo("avante"),
                () -> assertThat(avante.getDistance()).isEqualTo(100),
                () -> assertThat(avante.getFuelEfficiency()).isEqualTo(15)
        );
    }

}
