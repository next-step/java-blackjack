package rentCompany;

import org.junit.jupiter.api.Test;
import rentCompany.model.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CompanyTest {

    @Test
    void 회사는_5대의_목록을_가진다() {
        Company company = CompanyFactory.createCompany();

        company.addCar(new K5(130));
        company.addCar(new Sonata(100));
        company.addCar(new Sonata(200));
        company.addCar(new Avante(150));
        company.addCar(new Avante(300));

        assertAll(
                () -> assertThat(company.getCars().size()).isEqualTo(5),
                () -> assertThat(company.getCars().stream()
                        .filter(Car -> Car.getName() == "sonata")
                        .count()).isEqualTo(2),
                () -> assertThat(company.getCars().stream()
                        .filter(Car -> Car.getName() == "K5")
                        .count()).isEqualTo(1),
                () -> assertThat(company.getCars().stream()
                        .filter(Car -> Car.getName() == "avante")
                        .count()).isEqualTo(2)
        );
    }
}
