package rentcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void report() {
        final RentCompany company = RentCompany.create(); // factory method를 사용해 생성
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        final String report = company.generateReport();

        assertThat(report).isEqualTo(
                "소나타 : 15.0리터" + NEWLINE +
                "K5 : 20.0리터" + NEWLINE +
                "소나타 : 12.0리터" + NEWLINE +
                "아반떼 : 20.0리터" + NEWLINE +
                "K5 : 30.0리터" + NEWLINE
        );
    }
}
