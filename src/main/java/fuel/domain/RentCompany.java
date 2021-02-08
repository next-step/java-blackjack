package fuel.domain;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private final List<Car> rentCars = new ArrayList<>();

    private RentCompany() {
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        this.rentCars.add(car);
    }

    public List<Car> getRentCars() {
        return this.rentCars;
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for (final Car rentCar : this.rentCars) {
            report.append(rentCar.getName())
                    .append(" : ")
                    .append(Math.floor(rentCar.getChargeQuantity() * 10) / 10)
                    .append("리터\n");
        }
        return report.toString();
    }
}
