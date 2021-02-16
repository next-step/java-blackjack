package rentcar;


import java.util.List;
import java.util.ArrayList;

public class RentCompany {
    private final List<Car> cars = new ArrayList<>();

    private RentCompany() {
        //private으로 외부에서 생성을 막는다.
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.report()).append("\n");
        }
        return stringBuilder.toString();
    }
}