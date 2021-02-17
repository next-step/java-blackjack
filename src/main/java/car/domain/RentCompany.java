package car.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {

    private List<CarImpl> cars;
    private static final String DELIMITER = "";
    private static final String COLON = " : ";
    private static final String LITTER_NEW_LINE = "리터\n";

    public static RentCompany create() {
        RentCompany rentCompany = new RentCompany();
        rentCompany.cars = new ArrayList<>();
        return rentCompany;
    }

    public String generateReport() {
        return cars.stream().map(car -> String.join(
            DELIMITER,
            car.getName(),
            COLON,
            String.format("%d", (int) Math.ceil(car.getChargeQuantity())),
            LITTER_NEW_LINE
        )).collect(Collectors.joining());
    }

    public void addCar(CarImpl car) {
        cars.add(car);
    }
}
