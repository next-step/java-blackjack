package rentcompany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentCompany {

    private static final String NEWLINE = System.getProperty("line.separator");
    public List<Car> rentCar = new ArrayList<>();

    private RentCompany() {
    }

    public List<Car> getRentCar() {
        return rentCar;
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        rentCar.add(car);
    }

    public String generateReport() {
         String report = rentCar.stream()
                .map(car -> car.getName() + " : " + (int)car.getChargeQuantity() + "리터" +NEWLINE)
                .collect(Collectors.joining());

        return report;
    }
}
