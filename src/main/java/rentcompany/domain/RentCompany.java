package rentcompany.domain;

import java.util.ArrayList;
import java.util.List;
import rentcompany.domain.car.PassengerCar;

public class RentCompany {

    private static final String COLON = " : ";
    private static final String LITER = "리터";
    private static final String NEWLINE = "\n";

    private final List<PassengerCar> cars;

    public RentCompany() {
        this.cars = new ArrayList<>();
    }

    public void addCar(final PassengerCar car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();

        for (PassengerCar car: cars) {
            sb.append(car.getName())
                .append(COLON)
                .append(String.format("%d", (int) car.getChargeQuantity()))
                .append(LITER)
                .append(NEWLINE);
        }

        return sb.toString();
    }

}
