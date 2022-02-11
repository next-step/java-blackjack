package fuelInjection;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @DisplayName("`Sonata` String Type 이름을 가져야한다.")
    @Test
    public void givenSonataClass_whenCreateInstance_thenInstanceNameIsSonata () {
        Sonata sonata = new Sonata();

        assertThat(sonata.getName())
            .isEqualTo("Sonata");
    }

    @Test
    public void report() throws Exception {
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
                "K5 : 30리터" + NEWLINE
        );
    }
}
