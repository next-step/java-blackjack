package rentcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RentCompanyTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    private RentCompany rentCompany;
    List<Car> carList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        rentCompany = new RentCompany();
        carList.add(new Sonata(150));
        carList.add(new K5(150));
        carList.add(new Sonata(150));
        carList.add(new Avante(150));
        carList.add(new K5(150));
        rentCompany.addCars(carList);
    }

    @DisplayName("자동차 등록이 제대로 되어 있는지 확인하는 테스트")
    @Test
    void addCarToRentCompany() {
        assertThat(rentCompany.getCarList()).isEqualTo(carList);
    }

    @DisplayName("차량 추가 차량 수가 증가했는지 테스트.")
    @Test
    void carListLength() {
        int beforeAddCar = rentCompany.getCarList().size();
        Car car = new Sonata(150);
        rentCompany.addCar(car);
        int afterAddCar = rentCompany.getCarList().size();
        assertThat(afterAddCar).isEqualTo(beforeAddCar + 1);
    }

    @DisplayName("보고서를 제대로 만드는지 테스트.")
    @Test
    void generateReport() {
        String report = rentCompany.generateReport();
        assertThat(report).isEqualTo(
            "Sonata : 15리터" + NEW_LINE +
                "K5 : 11리터" + NEW_LINE +
                "Sonata : 15리터" + NEW_LINE +
                "AVANTE : 10리터" + NEW_LINE +
                "K5 : 11리터" + NEW_LINE
        );
    }
}