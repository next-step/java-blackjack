package rentcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");

    @DisplayName("RentCompany_객체_생성_테스트")
    @Test
    public void createRentCarTest() {
        RentCompany company = RentCompany.create();
        assertThat(company).isNotNull();
    }

    @DisplayName("RentCompany_Car_추가_테스트")
    @Test
    public void addCarTest() {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150));
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));
        assertThat(company.cars().size()).isEqualTo(6);
    }

    @DisplayName("RentCompany_레포트_생성_테스트")
    @Test
    public void generateReportTest() {
        RentCompany company = RentCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
            "Sonata : 15리터" + NEWLINE +
                "K5 : 20리터" + NEWLINE +
                "Sonata : 12리터" + NEWLINE +
                "Avante : 20리터" + NEWLINE +
                "K5 : 30리터"
        );
    }
}