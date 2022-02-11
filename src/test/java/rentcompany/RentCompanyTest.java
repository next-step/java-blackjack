package rentcompany;

import static org.assertj.core.api.Assertions.assertThat;

import rentcompany.domain.car.Avante;
import rentcompany.domain.car.K5;
import rentcompany.domain.RentCompany;
import rentcompany.domain.car.Sonata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentCompanyTest {

    private static final String NEWLINE = "\n";

    // RentCompany
    // - 자동차 리스트
    // - 연료량 리포트

    @DisplayName("연료량 리포트 테스트 - 렌트카 업체에 자동차 목록, 대략적인 이동거리를 입력받으면, 주입해야 하는 연료량 확인할 수 있는 보고서가 작성됩니다.")
    @Test
    void testReportResultValid() {
        // Given
        RentCompany company = new RentCompany();
        company.addCar(new Sonata(150));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(260));
        company.addCar(new K5(390));

        // When
        String report = company.generateReport();

        // Then
        assertThat(report)
            .isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                "Sonata : 12리터" + NEWLINE +
                "Avante : 20리터" + NEWLINE +
                "K5 : 20리터" + NEWLINE +
                "K5 : 30리터" + NEWLINE
            );
    }
}
