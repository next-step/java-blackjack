package fuel.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RentCompanyTest {

    private RentCompany rentCompany;

    @BeforeEach
    public void setUp() {
        rentCompany = RentCompany.create();
    }

    @DisplayName("렌트카 회사에 차량 추가 테스트")
    @Test
    void addCarTest() {
        // given & when
        rentCompany.addCar(new Sonata(150));
        List<Car> rentCars = rentCompany.getRentCars();

        // then
        assertThat(rentCars.size()).isEqualTo(1);
    }

    @DisplayName("보고서 생셩 결과")
    @Test
    void generateReportTest() {
        // given & when
        rentCompany.addCar(new Sonata(150));
        rentCompany.addCar(new K5(260));

        // when
        String report = rentCompany.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15.0리터" + "\n" +
                        "K5 : 20.0리터" + "\n"
        );
    }
}