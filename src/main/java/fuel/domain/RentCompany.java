package fuel.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final List<Car> carLists = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        carLists.add(car);
    }

    public String generateReport(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carLists) {
            stringBuilder.append(car.getName()).append(" : ").append(car.getChargeQuantity()).append("리터").append(NEWLINE);
        }
        return stringBuilder.toString();
    }

}
