package rentcompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String LITER = "리터";

    private List<Car> cars;

    private RentCompany() {
        cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();
        for(Car car : cars){
            report.append(car.getName()+" : "+(int)car.getChargeQuantity()+ LITER + NEW_LINE);
        }
        System.out.println(report);
        return report.toString();
    }
}
