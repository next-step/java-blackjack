package fuelInjection;

import static org.assertj.core.api.Assertions.assertThat;

import fuelInjection.domain.Avante;
import fuelInjection.domain.Car;
import fuelInjection.domain.K5;
import fuelInjection.domain.Sonata;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RentCompanyTest {

    private static final String NEWLINE = System.getProperty("line.separator");
    int TEMP_DISTANCE = 10;

    @Test
    void Car의_List를_가져야한다() {
        RentCompany company = RentCompany.create();

        assertThat(company.getRentCars().size())
            .isEqualTo(0);
    }

    @Test
    void Car의_List에_Sonata를_추가할_수_있다() {
        RentCompany company = RentCompany.create();
        Sonata sonata = new Sonata(TEMP_DISTANCE);
        List<Car> cars = Arrays.asList(sonata);

        company.addCar(sonata);
        assertThat(company.getRentCars().equals(cars))
            .isTrue();
    }

    @Test
    void Car의_List에_Avante를_추가할_수_있다() {
        RentCompany company = RentCompany.create();
        Avante avante = new Avante(TEMP_DISTANCE);
        List<Car> cars = Arrays.asList(avante);

        company.addCar(avante);
        assertThat(company.getRentCars().equals(cars))
            .isTrue();
    }

    @Test
    void Car의_List에_K5를_추가할_수_있다() {
        RentCompany company = RentCompany.create();
        K5 k5 = new K5(TEMP_DISTANCE);
        List<Car> cars = Arrays.asList(k5);

        company.addCar(k5);
        assertThat(company.getRentCars().equals(cars))
            .isTrue();
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
