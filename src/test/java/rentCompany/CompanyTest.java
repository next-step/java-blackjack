package rentCompany;

import org.junit.jupiter.api.Test;
import rentCompany.model.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static rentCompany.model.Company.NEW_LINE;

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
                        .filter(Car -> Car.getName() == "Sonata")
                        .count()).isEqualTo(2),
                () -> assertThat(company.getCars().stream()
                        .filter(Car -> Car.getName() == "K5")
                        .count()).isEqualTo(1),
                () -> assertThat(company.getCars().stream()
                        .filter(Car -> Car.getName() == "Avante")
                        .count()).isEqualTo(2)
        );
    }

    @Test
    void 회사는_리포트를_출력한다() {
        Company company = CompanyFactory.createCompany();

        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String result = company.makeReport().toString();

        assertThat(result).isEqualTo(
                "Sonata : 15리터" + NEW_LINE +
                        "K5 : 20리터" + NEW_LINE +
                        "Sonata : 12리터" + NEW_LINE +
                        "Avante : 20리터" + NEW_LINE +
                        "K5 : 30리터" + NEW_LINE
        );
    }
}
