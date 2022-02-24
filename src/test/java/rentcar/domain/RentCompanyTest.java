package rentcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RentCompanyTest {

    @Test
    void 자동차_이름과_연료량을_받아_map을_반환한다() {
        List<Car> cars = new ArrayList<>();

        cars.add(new Avante(300));
        cars.add(new K5(260));
        cars.add(new Sonata(150));

        RentCompany rentCompany = new RentCompany(cars);

        Report report = rentCompany.generateChargeQuantityByName();

        org.junit.jupiter.api.Assertions.assertAll(
            () -> assertThat(report.getReport().get("Avante")).isEqualTo(20),
            () -> assertThat(report.getReport().get("K5")).isEqualTo(20),
            () -> assertThat(report.getReport().get("Sonata")).isEqualTo(15)
        );
    }
}
