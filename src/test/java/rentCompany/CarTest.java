package rentCompany;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import rentCompany.model.Avante;
import rentCompany.model.Car;
import rentCompany.model.K5;
import rentCompany.model.Sonata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    @Test
    void createK5() {
        Car k5 = new K5(100);

        assertAll(
                () -> assertThat(k5.getName()).isEqualTo("K5"),
                () -> assertThat(k5.getDistance()).isEqualTo(100),
                () -> assertThat(k5.getFuelEfficiency()).isEqualTo(13)
        );
    }

    @Test
    void createSonata() {
        Car sonata = new Sonata(100);

        assertAll(
                () -> assertThat(sonata.getName()).isEqualTo("Sonata"),
                () -> assertThat(sonata.getDistance()).isEqualTo(100),
                () -> assertThat(sonata.getFuelEfficiency()).isEqualTo(10)
        );
    }

    @Test
    void createAvante() {
        Car avante = new Avante(150);

        assertAll(
                () -> assertThat(avante.getName()).isEqualTo("Avante"),
                () -> assertThat(avante.getDistance()).isEqualTo(150),
                () -> assertThat(avante.getFuelEfficiency()).isEqualTo(15)
        );
    }

    @ParameterizedTest
    @CsvSource(value = "130,100,150", delimiterString = ",")
    void 거리이동에_필요한_연료량_구하기(int k5Distance, int sonataDistance, int avanteDistance) {
        final Car k5 = new K5(k5Distance);
        final Car sonata = new Sonata(sonataDistance);
        final Car avante = new Avante(avanteDistance);

        assertAll(
                () -> assertThat(k5.getFuelRequiredAmount()).isEqualTo(10),
                () -> assertThat(sonata.getFuelRequiredAmount()).isEqualTo(10),
                () -> assertThat(avante.getFuelRequiredAmount()).isEqualTo(10)
        );
    }
}
