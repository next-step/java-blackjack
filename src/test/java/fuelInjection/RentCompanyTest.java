package fuelInjection;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import fuelInjection.domain.Avante;
import fuelInjection.domain.K5;
import fuelInjection.domain.Sonata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    void Car의_List를_가져야한다() {
        RentCompany company = RentCompany.create();

        assertThat(company.getCars().size())
            .isEqualTo(0);
    }

//    @Test
//    public void report() throws Exception {
//        RentCompany company = RentCompany.create(); // factory method를 사용해 생성
//        company.addCar(new Sonata(150));
//        company.addCar(new K5(260));
//        company.addCar(new Sonata(120));
//        company.addCar(new Avante(300));
//        company.addCar(new K5(390));
//
//        String report = company.generateReport();
//        assertThat(report).isEqualTo(
//            "Sonata : 15리터" + NEWLINE +
//                "K5 : 20리터" + NEWLINE +
//                "Sonata : 12리터" + NEWLINE +
//                "Avante : 20리터" + NEWLINE +
//                "K5 : 30리터" + NEWLINE
//        );
//    }
}
